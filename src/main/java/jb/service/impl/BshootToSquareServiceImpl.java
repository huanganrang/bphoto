package jb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import jb.absx.F;
import jb.dao.BshootToSquareDaoI;
import jb.model.TbshootToSquare;
import jb.pageModel.BshootToSquare;
import jb.pageModel.DataGrid;
import jb.pageModel.PageHelper;
import jb.service.BshootToSquareServiceI;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BshootToSquareServiceImpl extends BaseServiceImpl<BshootToSquare> implements BshootToSquareServiceI {

	@Autowired
	private BshootToSquareDaoI bshootToSquareDao;

	@Override
	public DataGrid dataGrid(BshootToSquare bshootToSquare, PageHelper ph) {
		List<BshootToSquare> ol = new ArrayList<BshootToSquare>();
		String hql = " from TbshootToSquare t ";
		DataGrid dg = dataGridQuery(hql, ph, bshootToSquare, bshootToSquareDao);
		@SuppressWarnings("unchecked")
		List<TbshootToSquare> l = dg.getRows();
		if (l != null && l.size() > 0) {
			for (TbshootToSquare t : l) {
				BshootToSquare o = new BshootToSquare();
				BeanUtils.copyProperties(t, o);
				ol.add(o);
			}
		}
		dg.setRows(ol);
		return dg;
	}
	

	protected String whereHql(BshootToSquare bshootToSquare, Map<String, Object> params) {
		String whereHql = "";	
		if (bshootToSquare != null) {
			whereHql += " where 1=1 ";
			if (!F.empty(bshootToSquare.getBshootId())) {
				whereHql += " and t.bshootId = :bshootId";
				params.put("bshootId", bshootToSquare.getBshootId());
			}		
			if (!F.empty(bshootToSquare.getSquareId())) {
				whereHql += " and t.squareId = :squareId";
				params.put("squareId", bshootToSquare.getSquareId());
			}		
			if (!F.empty(bshootToSquare.getAuditorId())) {
				whereHql += " and t.auditorId = :auditorId";
				params.put("auditorId", bshootToSquare.getAuditorId());
			}		
			if (!F.empty(bshootToSquare.getReason())) {
				whereHql += " and t.reason = :reason";
				params.put("reason", bshootToSquare.getReason());
			}		
			if (!F.empty(bshootToSquare.getStatus())) {
				whereHql += " and t.status = :status";
				params.put("status", bshootToSquare.getStatus());
			}		
		}	
		return whereHql;
	}

	@Override
	public void add(BshootToSquare bshootToSquare) {
		TbshootToSquare t = new TbshootToSquare();
		BeanUtils.copyProperties(bshootToSquare, t);
		t.setId(UUID.randomUUID().toString());
		//t.setCreatedatetime(new Date());
		bshootToSquareDao.save(t);
	}

	@Override
	public BshootToSquare get(String id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		TbshootToSquare t = bshootToSquareDao.get("from TbshootToSquare t  where t.id = :id", params);
		BshootToSquare o = new BshootToSquare();
		BeanUtils.copyProperties(t, o);
		return o;
	}

	@Override
	public void edit(BshootToSquare bshootToSquare) {
		TbshootToSquare t = bshootToSquareDao.get(TbshootToSquare.class, bshootToSquare.getId());
		if (t != null) {
			BeanUtils.copyProperties(bshootToSquare, t, new String[] { "id" , "createdatetime" });
			//t.setModifydatetime(new Date());
		}
	}

	@Override
	public void delete(String id) {
		bshootToSquareDao.delete(bshootToSquareDao.get(TbshootToSquare.class, id));
	}


	@Override
	public int addFromUser(BshootToSquare bshootToSquare) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bshootId", bshootToSquare.getBshootId());
		TbshootToSquare old = bshootToSquareDao.get("from TbshootToSquare t  where t.bshootId = :bshootId and t.status not in('AS03')", params);
		if(old!=null)return -1;
		TbshootToSquare t = new TbshootToSquare();
		//未审核
		t.setStatus("AS01");
		BeanUtils.copyProperties(bshootToSquare, t);
		t.setId(UUID.randomUUID().toString());
		bshootToSquareDao.save(t);
		return 1;
		
	}

}
