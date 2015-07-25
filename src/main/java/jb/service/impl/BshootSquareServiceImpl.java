package jb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import jb.absx.F;
import jb.dao.BshootSquareDaoI;
import jb.model.TbshootSquare;
import jb.pageModel.BshootSquare;
import jb.pageModel.DataGrid;
import jb.pageModel.PageHelper;
import jb.service.BshootSquareServiceI;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BshootSquareServiceImpl extends BaseServiceImpl<BshootSquare> implements BshootSquareServiceI {

	@Autowired
	private BshootSquareDaoI bshootSquareDao;

	@Override
	public DataGrid dataGrid(BshootSquare bshootSquare, PageHelper ph) {
		List<BshootSquare> ol = new ArrayList<BshootSquare>();
		String hql = " from TbshootSquare t ";
		DataGrid dg = dataGridQuery(hql, ph, bshootSquare, bshootSquareDao);
		@SuppressWarnings("unchecked")
		List<TbshootSquare> l = dg.getRows();
		if (l != null && l.size() > 0) {
			for (TbshootSquare t : l) {
				BshootSquare o = new BshootSquare();
				BeanUtils.copyProperties(t, o);
				ol.add(o);
			}
		}
		dg.setRows(ol);
		return dg;
	}
	

	protected String whereHql(BshootSquare bshootSquare, Map<String, Object> params) {
		String whereHql = "";	
		if (bshootSquare != null) {
			whereHql += " where 1=1 ";
			if (!F.empty(bshootSquare.getBssName())) {
				whereHql += " and t.bssName = :bssName";
				params.put("bssName", bshootSquare.getBssName());
			}		
			if (!F.empty(bshootSquare.getBssDescription())) {
				whereHql += " and t.bssDescription = :bssDescription";
				params.put("bssDescription", bshootSquare.getBssDescription());
			}		
			if (!F.empty(bshootSquare.getBssIcon())) {
				whereHql += " and t.bssIcon = :bssIcon";
				params.put("bssIcon", bshootSquare.getBssIcon());
			}		
			if (!F.empty(bshootSquare.getBssUserId())) {
				whereHql += " and t.bssUserId = :bssUserId";
				params.put("bssUserId", bshootSquare.getBssUserId());
			}		
			if (!F.empty(bshootSquare.getCreatePerson())) {
				whereHql += " and t.createPerson = :createPerson";
				params.put("createPerson", bshootSquare.getCreatePerson());
			}		
			if (!F.empty(bshootSquare.getUpdatePerson())) {
				whereHql += " and t.updatePerson = :updatePerson";
				params.put("updatePerson", bshootSquare.getUpdatePerson());
			}	
			if (!F.empty(bshootSquare.getBssType())) {
				whereHql += " and t.bssType = :bssType";
				params.put("bssType", bshootSquare.getBssType());
			}	
		}	
		return whereHql;
	}

	@Override
	public void add(BshootSquare bshootSquare) {
		TbshootSquare t = new TbshootSquare();
		BeanUtils.copyProperties(bshootSquare, t);
		t.setCreateDatetime(new Date());
		bshootSquareDao.save(t);
	}

	@Override
	public BshootSquare get(String id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		TbshootSquare t = bshootSquareDao.get("from TbshootSquare t  where t.id = :id", params);
		if(t==null)return null;
		BshootSquare o = new BshootSquare();
		BeanUtils.copyProperties(t, o);
		return o;
	}

	@Override
	public void edit(BshootSquare bshootSquare) {
		TbshootSquare t = bshootSquareDao.get(TbshootSquare.class, bshootSquare.getId());
		if (t != null) {
			t.setUpdateDatetime(new Date());
			BeanUtils.copyProperties(bshootSquare, t, new String[] { "id" , "createDatetime" , "updateDatetime"});
		}
	}

	@Override
	public void delete(String id) {
		bshootSquareDao.delete(bshootSquareDao.get(TbshootSquare.class, id));
	}



}
