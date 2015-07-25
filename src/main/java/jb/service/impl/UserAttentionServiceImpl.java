package jb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import jb.absx.F;
import jb.dao.BaseDaoI;
import jb.dao.UserAttentionDaoI;
import jb.model.Tuser;
import jb.model.TuserAttention;
import jb.pageModel.Bshoot;
import jb.pageModel.DataGrid;
import jb.pageModel.PageHelper;
import jb.pageModel.User;
import jb.pageModel.UserAttention;
import jb.service.UserAttentionServiceI;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAttentionServiceImpl extends BaseServiceImpl<UserAttention> implements UserAttentionServiceI {

	@Autowired
	private UserAttentionDaoI userAttentionDao;

	@Override
	public DataGrid dataGrid(UserAttention userAttention, PageHelper ph) {
		List<UserAttention> ol = new ArrayList<UserAttention>();
		String hql = " from TuserAttention t ";
		DataGrid dg = dataGridQuery(hql, ph, userAttention, userAttentionDao);
		@SuppressWarnings("unchecked")
		List<TuserAttention> l = dg.getRows();
		if (l != null && l.size() > 0) {
			for (TuserAttention t : l) {
				UserAttention o = new UserAttention();
				BeanUtils.copyProperties(t, o);
				ol.add(o);
			}
		}
		dg.setRows(ol);
		return dg;
	}
	

	protected String whereHql(UserAttention userAttention, Map<String, Object> params) {
		String whereHql = "";	
		if (userAttention != null) {
			whereHql += " where 1=1 ";
			if (!F.empty(userAttention.getUserId())) {
				whereHql += " and t.userId = :userId";
				params.put("userId", userAttention.getUserId());
			}		
			if (!F.empty(userAttention.getAttUserId())) {
				whereHql += " and t.attUserId = :attUserId";
				params.put("attUserId", userAttention.getAttUserId());
			}		
		}	
		return whereHql;
	}

	@Override
	public int add(UserAttention userAttention) {
		if(get(userAttention.getUserId(), userAttention.getAttUserId())!=null){		
			return -1;
		}
		TuserAttention t = new TuserAttention();
		BeanUtils.copyProperties(userAttention, t);
		t.setId(UUID.randomUUID().toString());
		t.setAttentionDatetime(new Date());
		userAttentionDao.save(t);
		return 1;
	}

	@Override
	public UserAttention get(String id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		TuserAttention t = userAttentionDao.get("from TuserAttention t  where t.id = :id", params);
		UserAttention o = new UserAttention();
		BeanUtils.copyProperties(t, o);
		return o;
	}

	
	public UserAttention get(String userId,String attUserId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("attUserId", attUserId);		
		TuserAttention t = userAttentionDao.get("from TuserAttention t  where t.userId = :userId and t.attUserId = :attUserId", params);
		if(t==null)
			return null;
		UserAttention o = new UserAttention();
		BeanUtils.copyProperties(t, o);
		return o;
	}
	
	@Override
	public void edit(UserAttention userAttention) {
		TuserAttention t = userAttentionDao.get(TuserAttention.class, userAttention.getId());
		if (t != null) {
			BeanUtils.copyProperties(userAttention, t, new String[] { "id" , "createdatetime" });
			//t.setModifydatetime(new Date());
		}
	}

	@Override
	public void delete(String id) {
		userAttentionDao.delete(userAttentionDao.get(TuserAttention.class, id));
	}


	@Override
	public int deleteUa(UserAttention userAttention) {
		UserAttention ua = get(userAttention.getUserId(), userAttention.getAttUserId());
		if(ua==null){		
			return -1;
		}
		delete(ua.getId());
		return 1;
	}


	@Override
	public DataGrid dataGridUser(UserAttention userAttention, PageHelper ph) {
		List<User> ol = new ArrayList<User>();
		
		DataGrid dg = dataGridByType(ph, userAttention, userAttentionDao);
		@SuppressWarnings("unchecked")
		List<Tuser> l = dg.getRows();
		if (l != null && l.size() > 0) {
			for (Tuser t : l) {
				User o = new User();
				BeanUtils.copyProperties(t, o);
				ol.add(o);
			}
		}
		dg.setRows(ol);
		return dg;
	}

	private DataGrid dataGridByType(PageHelper ph,UserAttention userAttention,BaseDaoI dao){
		DataGrid dg = new DataGrid();
		String hql = "select u from Tuser u ,TuserAttention t  ";
		Map<String, Object> params = new HashMap<String, Object>();
		//我的关注好友
		if(!F.empty(userAttention.getUserId())){
			hql +="where u.id = t.attUserId and t.userId = :userId";
			params.put("userId",userAttention.getUserId());
		//我的粉丝	
		}else if(!F.empty(userAttention.getAttUserId())){
			hql +="where u.id = t.attUserId and t.attUserId = :userId";
			params.put("userId",userAttention.getAttUserId());
		}		
		List<Bshoot> l = dao.find(hql   + orderHql(ph), params, ph.getPage(), ph.getRows());
		dg.setTotal(dao.count("select count(*) " + hql.substring(8) , params));
		dg.setRows(l);
		return dg;
	}
}
