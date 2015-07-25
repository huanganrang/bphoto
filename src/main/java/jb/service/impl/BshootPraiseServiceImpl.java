package jb.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import jb.absx.F;
import jb.dao.BshootDaoI;
import jb.dao.BshootPraiseDaoI;
import jb.model.TbshootPraise;
import jb.pageModel.BshootPraise;
import jb.pageModel.BshootPraiseExt;
import jb.pageModel.DataGrid;
import jb.pageModel.PageHelper;
import jb.service.BshootPraiseServiceI;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BshootPraiseServiceImpl extends BaseServiceImpl<BshootPraise> implements BshootPraiseServiceI {

	@Autowired
	private BshootPraiseDaoI bshootPraiseDao;
	
	@Autowired
	private BshootDaoI bshootDao;
	

	@Override
	public DataGrid dataGrid(BshootPraise bshootPraise, PageHelper ph) {
		List<BshootPraise> ol = new ArrayList<BshootPraise>();
		String hql = " from TbshootPraise t ";
		DataGrid dg = dataGridQuery(hql, ph, bshootPraise, bshootPraiseDao);
		@SuppressWarnings("unchecked")
		List<TbshootPraise> l = dg.getRows();
		if (l != null && l.size() > 0) {
			for (TbshootPraise t : l) {
				BshootPraise o = new BshootPraise();
				BeanUtils.copyProperties(t, o);
				ol.add(o);
			}
		}
		dg.setRows(ol);
		return dg;
	}
	

	protected String whereHql(BshootPraise bshootPraise, Map<String, Object> params) {
		String whereHql = "";	
		if (bshootPraise != null) {
			whereHql += " where 1=1 ";
			if (!F.empty(bshootPraise.getUserId())) {
				whereHql += " and t.userId = :userId";
				params.put("userId", bshootPraise.getUserId());
			}		
			if (!F.empty(bshootPraise.getBshootId())) {
				whereHql += " and t.bshootId = :bshootId";
				params.put("bshootId", bshootPraise.getBshootId());
			}		
		}	
		return whereHql;
	}

	@Override
	public int add(BshootPraise bshootPraise) {
		if(get(bshootPraise.getBshootId(), bshootPraise.getUserId())!=null)
			return -1;
		TbshootPraise t = new TbshootPraise();
		BeanUtils.copyProperties(bshootPraise, t);
		t.setId(UUID.randomUUID().toString());
		bshootPraise.setId(t.getId());
		//t.setCreatedatetime(new Date());
		t.setPraiseDatetime(new Date());
		bshootPraiseDao.save(t);
		updateCount(bshootPraise.getBshootId());
		return 1;
	}

	@Override
	public BshootPraise get(String id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		TbshootPraise t = bshootPraiseDao.get("from TbshootPraise t  where t.id = :id", params);
		BshootPraise o = new BshootPraise();
		BeanUtils.copyProperties(t, o);
		return o;
	}

	@Override
	public void edit(BshootPraise bshootPraise) {
		TbshootPraise t = bshootPraiseDao.get(TbshootPraise.class, bshootPraise.getId());
		if (t != null) {
			BeanUtils.copyProperties(bshootPraise, t, new String[] { "id" , "createdatetime" });
			//t.setModifydatetime(new Date());
		}
	}

	@Override
	public void delete(String id) {
		TbshootPraise t = bshootPraiseDao.get(TbshootPraise.class, id);
		bshootPraiseDao.delete(t);
		updateCountReduce(t.getBshootId());
	}


	@Override
	public int deleteBshootPraise(BshootPraise bshootPraise) {
		BshootPraise bc = get(bshootPraise.getBshootId(), bshootPraise.getUserId());
		if(bc==null){
			return -1;
		}else{
			delete(bc.getId());
		}
		return 0;
		
	}
	
	private void updateCount(String bshootId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bshootId", bshootId);
		params.put("id", bshootId);
		bshootDao.executeSql("update bshoot t set t.bs_praise = (select count(*)+1 from bshoot_praise b where b.bshoot_id =:bshootId) where t.id=:id", params);
	}

	private void updateCountReduce(String bshootId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bshootId", bshootId);
		params.put("id", bshootId);
		bshootDao.executeSql("update bshoot t set t.bs_praise = (select count(*)-1 from bshoot_praise b where b.bshoot_id =:bshootId) where t.id=:id", params);
	}

	public BshootPraise get(String bshootId, String userId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bshootId", bshootId);
		params.put("userId", userId);
		TbshootPraise t = bshootPraiseDao.get("from TbshootPraise t  where t.bshootId = :bshootId and t.userId = :userId", params);
		if(t==null)return null;
		BshootPraise o = new BshootPraise();
		BeanUtils.copyProperties(t, o);
		return o;
	}


	@Override
	public DataGrid dataGridLike(BshootPraise bshootPraise, PageHelper ph) {	
		List<BshootPraiseExt> ol = new ArrayList<BshootPraiseExt>();
		String sqlSelect = "select t.bshoot_id as bshootId,"
				+ " t.praise_datetime as praiseDatetime,"
				+ " t.user_Id as userId,"
				+ " b.bs_icon as bsIcon,"
				+ " u.head_Image as headImage,"
				+ " u.nickname ";
		String sqlFrom = " from bshoot_praise t "
				+ " left join tuser u on u.id=t.user_id "
				+ " left join bshoot b on b.id=t.bshoot_id "
				+ "where exists (select 1 from message m where m.m_type = 'MT04' and m.user_id = :userId and m.relation_Id = t.id)";
		DataGrid dg = new DataGrid();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", bshootPraise.getUserId());
		List<Map> l = bshootPraiseDao.findBySql2Map(sqlSelect+sqlFrom, params,  ph.getPage(), ph.getRows());
		dg.setTotal(bshootPraiseDao.countBySql("select count(*)" +sqlFrom+"", params).longValue());
		dg.setRows(l);
		if (l != null && l.size() > 0) {
			for (Map t : l) {
				BshootPraiseExt o = new BshootPraiseExt();
				try {
					org.apache.commons.beanutils.BeanUtils.populate(o, t);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ol.add(o);
			}
		}	
		dg.setRows(ol);
		return dg;		
	}
}
