package jb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import jb.absx.F;
import jb.dao.CarDaoI;
import jb.model.Tcar;
import jb.pageModel.Car;
import jb.pageModel.DataGrid;
import jb.pageModel.PageHelper;
import jb.service.CarServiceI;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends BaseServiceImpl<Car> implements CarServiceI {

	@Autowired
	private CarDaoI carDao;

	@Override
	public DataGrid dataGrid(Car car, PageHelper ph) {
		List<Car> ol = new ArrayList<Car>();
		String hql = " from Tcar t ";
		DataGrid dg = dataGridQuery(hql, ph, car, carDao);
		@SuppressWarnings("unchecked")
		List<Tcar> l = dg.getRows();
		if (l != null && l.size() > 0) {
			for (Tcar t : l) {
				Car o = new Car();
				BeanUtils.copyProperties(t, o);
				ol.add(o);
			}
		}
		dg.setRows(ol);
		return dg;
	}
	

	protected String whereHql(Car car, Map<String, Object> params) {
		String whereHql = "";	
		if (car != null) {
			whereHql += " where 1=1 ";
			if (!F.empty(car.getName())) {
				whereHql += " and t.name = :name";
				params.put("name", car.getName());
			}		
			if (!F.empty(car.getCode())) {
				whereHql += " and t.code = :code";
				params.put("code", car.getCode());
			}		
			if (!F.empty(car.getUserName())) {
				whereHql += " and t.userName = :userName";
				params.put("userName", car.getUserName());
			}		
		}	
		return whereHql;
	}

	@Override
	public void add(Car car) {
		Tcar t = new Tcar();
		BeanUtils.copyProperties(car, t);
		t.setId(UUID.randomUUID().toString());
		//t.setCreatedatetime(new Date());
		carDao.save(t);
	}

	@Override
	public Car get(String id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Tcar t = carDao.get("from Tcar t  where t.id = :id", params);
		Car o = new Car();
		BeanUtils.copyProperties(t, o);
		return o;
	}

	@Override
	public void edit(Car car) {
		Tcar t = carDao.get(Tcar.class, car.getId());
		if (t != null) {
			BeanUtils.copyProperties(car, t, new String[] { "id" , "createdatetime" });
			//t.setModifydatetime(new Date());
		}
	}

	@Override
	public void delete(String id) {
		carDao.delete(carDao.get(Tcar.class, id));
	}

}
