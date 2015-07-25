package jb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jb.dao.BasedataDaoI;
import jb.dao.BasetypeDaoI;
import jb.listener.Application;
import jb.model.Tbasedata;
import jb.pageModel.BaseData;
import jb.pageModel.DataGrid;
import jb.pageModel.PageHelper;
import jb.service.BasedataServiceI;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasedataServiceImpl implements BasedataServiceI {
	@Autowired
	private BasedataDaoI basedataDao;
	
	@Autowired
	private BasetypeDaoI basetypeDao;
	
	@Override
	public void add(BaseData baseData) {
		Tbasedata bd = new Tbasedata();
		BeanUtils.copyProperties(baseData, bd, new String[] { "basetypeCode" });
		bd.setBaseType(basetypeDao.getById(baseData.getBasetypeCode()));
		basedataDao.save(bd);
		refeshAppVariable(bd);
	}

	private void refeshAppVariable(Tbasedata bd){
		if(bd.getBaseType().getType()==0){
			Application.refresh();
		}
	}
	
	@Override
	public BaseData get(String id) {
		BaseData bd  = new BaseData();
		Tbasedata basedata = basedataDao.get(Tbasedata.class, id);
		BeanUtils.copyProperties(basedata, bd, new String[] { "basetypeCode" });
		bd.setBasetypeCode(basedata.getBaseType().getCode());
		bd.setCodeName(basedata.getBaseType().getName());
		return bd;
	}

	@Override
	public void edit(BaseData baseData) {
		Tbasedata bd = basedataDao.get(Tbasedata.class, baseData.getId());
		if(bd!=null){
			BeanUtils.copyProperties(baseData, bd, new String[] { "id"});
			bd.setBaseType(basetypeDao.getById(baseData.getBasetypeCode()));
			refeshAppVariable(bd);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public DataGrid dataGrid(BaseData baseData, PageHelper ph) {
		DataGrid dg = new DataGrid();
		List<BaseData> bl = new ArrayList<BaseData>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from Tbasedata t ";
		String joinHql = " left join t.baseType type ";
		String where = whereHql(baseData, params);
		List l = basedataDao.find(hql + joinHql + where + orderHql(ph), params, ph.getPage(), ph.getRows());
		if (l != null && l.size() > 0) {
			Tbasedata temp = null;
			for (Object t : l) {
				temp = (Tbasedata)((Object[])t)[0];
				BaseData b = new BaseData();
				BeanUtils.copyProperties(temp, b);
				b.setCodeName(temp.getBaseType().getName());
				b.setBasetypeCode(temp.getBaseType().getCode());
				bl.add(b);
			}
		}
		dg.setRows(bl);
		dg.setTotal(basedataDao.count("select count(*) " + hql + joinHql + where, params));
		return dg;
	}
	
	private String orderHql(PageHelper ph) {
		String orderString = "";
		if (ph.getSort() != null && ph.getOrder() != null) {
			orderString = " order by t." + ph.getSort() + " " + ph.getOrder();
		}
		return orderString;
	}

	private String whereHql(BaseData bd, Map<String, Object> params) {
		String whereHql = "";
		if (bd != null) {
			whereHql += " where 1=1 ";
			if (bd.getName() != null) {
				whereHql += " and t.name like :name";
				params.put("name", "%%" + bd.getName() + "%%");
			}	
			if(bd.getBasetypeCode()!=null&&bd.getBasetypeCode().length()>0){
				whereHql += " and type.code = :code";
				params.put("code",bd.getBasetypeCode());
			}
		}
		return whereHql;
	}

	@Override
	public void delete(String id) {
		Tbasedata basedata = basedataDao.get(Tbasedata.class, id);
		basedata.getBaseType();
		basedataDao.delete(basedata);
		refeshAppVariable(basedata);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Map<String,BaseData> getAppVariable() {
		String hql = " from Tbasedata t left join t.baseType type  where type.type = :type";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("type", 0);
		List l = basedataDao.find(hql, params);
		Map<String,BaseData> variable = new HashMap<String,BaseData>();
		if (l != null && l.size() > 0) {
			Tbasedata temp = null;
			for (Object t : l) {
				temp = (Tbasedata)((Object[])t)[0];
				BaseData b = new BaseData();
				BeanUtils.copyProperties(temp, b);
				b.setCodeName(temp.getBaseType().getName());
				b.setBasetypeCode(temp.getBaseType().getCode());
				variable.put(b.getId(), b);
			}
		}
		return variable;
	}

	@Override
	public List<BaseData> getBaseDatas(String baseType) {
		List<BaseData> bl = new ArrayList<BaseData>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from Tbasedata t ";
		String joinHql = " left join t.baseType type ";
		BaseData baseData = new BaseData();
		baseData.setBasetypeCode(baseType);
		String where = whereHql(baseData, params);
		List l = basedataDao.find(hql + joinHql + where , params);
		if (l != null && l.size() > 0) {
			Tbasedata temp = null;
			for (Object t : l) {
				temp = (Tbasedata)((Object[])t)[0];
				BaseData b = new BaseData();
				BeanUtils.copyProperties(temp, b);
				b.setCodeName(temp.getBaseType().getName());
				b.setBasetypeCode(temp.getBaseType().getCode());
				bl.add(b);
			}
		}
		return bl;
	}

}
