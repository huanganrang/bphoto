package jb.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import jb.absx.F;
import jb.dao.BaseDaoI;
import jb.dao.BshootDaoI;
import jb.dao.UserDaoI;
import jb.model.Tbshoot;
import jb.model.Tuser;
import jb.pageModel.Bshoot;
import jb.pageModel.DataGrid;
import jb.pageModel.PageHelper;
import jb.service.BshootServiceI;
import jb.util.PathUtil;
import jb.util.RoundTool;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BshootServiceImpl extends BaseServiceImpl<Bshoot> implements BshootServiceI {

	@Autowired
	private BshootDaoI bshootDao;
	
	@Autowired
	private UserDaoI userDao;

	@Override
	public DataGrid dataGrid(Bshoot bshoot, PageHelper ph) {
		List<Bshoot> ol = new ArrayList<Bshoot>();
		String hql = " from Tbshoot t ";
		DataGrid dg = dataGridQuery(hql, ph, bshoot, bshootDao);
		@SuppressWarnings("unchecked")
		List<Tbshoot> l = dg.getRows();
		if (l != null && l.size() > 0) {
			for (Tbshoot t : l) {
				Bshoot o = new Bshoot();
				BeanUtils.copyProperties(t, o);
				ol.add(o);
			}
		}
		dg.setRows(ol);
		return dg;
	}
	@Override
	public DataGrid dataGrid(Bshoot bshoot, PageHelper ph, int qtype) {
		List<Bshoot> ol = new ArrayList<Bshoot>();
		String hql = " from Tbshoot t ";
		DataGrid dg = dataGridByType(hql, ph, bshoot, bshootDao,qtype);
		@SuppressWarnings("unchecked")
		List<Tbshoot> l = dg.getRows();
		if (l != null && l.size() > 0) {
			for (Tbshoot t : l) {
				Bshoot o = new Bshoot();
				BeanUtils.copyProperties(t, o);
				ol.add(o);
			}
		}
		dg.setRows(ol);
		return dg;
	}
	
	
	

	private DataGrid dataGridByType(String hql,PageHelper ph,Bshoot t,BaseDaoI dao,int qtype){
		DataGrid dg = new DataGrid();
		Map<String, Object> params = new HashMap<String, Object>();
		String where = " where t.userId = :userId";
		params.put("userId", t.getUserId());
		//我的美拍
		if(qtype==1){
			where +=" and t.parentId is null";
		//我的转发
		}else if(qtype==2){
			where +=" and t.parentId is not null";
		}
		List<Bshoot> l = dao.find(hql  + where + orderHql(ph), params, ph.getPage(), ph.getRows());
		dg.setTotal(dao.count("select count(*) " + hql + where, params));
		dg.setRows(l);
		return dg;
	}
	
	
	
	protected String whereHql(Bshoot bshoot, Map<String, Object> params) {
		String whereHql = "";	
		if (bshoot != null) {
			whereHql += " where 1=1 ";
			if (!F.empty(bshoot.getBsTitle())) {
				whereHql += " and t.bsTitle = :bsTitle";
				params.put("bsTitle", bshoot.getBsTitle());
			}		
			if (!F.empty(bshoot.getBsTopic())) {
				whereHql += " and t.bsTopic = :bsTopic";
				params.put("bsTopic", bshoot.getBsTopic());
			}		
			if (!F.empty(bshoot.getBsIcon())) {
				whereHql += " and t.bsIcon = :bsIcon";
				params.put("bsIcon", bshoot.getBsIcon());
			}		
			if (!F.empty(bshoot.getBsStream())) {
				whereHql += " and t.bsStream = :bsStream";
				params.put("bsStream", bshoot.getBsStream());
			}		
			/*if (!F.empty(bshoot.getBsCollect())) {
				whereHql += " and t.bsCollect = :bsCollect";
				params.put("bsCollect", bshoot.getBsCollect());
			}		
			if (!F.empty(bshoot.getBsPraise())) {
				whereHql += " and t.bsPraise = :bsPraise";
				params.put("bsPraise", bshoot.getBsPraise());
			}	*/	
			if (!F.empty(bshoot.getBsType())) {
				whereHql += " and t.bsType = :bsType";
				params.put("bsType", bshoot.getBsType());
			}		
			if (!F.empty(bshoot.getBsComment())) {
				whereHql += " and t.bsComment = :bsComment";
				params.put("bsComment", bshoot.getBsComment());
			}		
			if (!F.empty(bshoot.getUserId())) {
				whereHql += " and t.userId = :userId";
				params.put("userId", bshoot.getUserId());
			}		
			if (!F.empty(bshoot.getBsDescription())) {
				whereHql += " and t.bsDescription = :bsDescription";
				params.put("bsDescription", bshoot.getBsDescription());
			}		
			if (!F.empty(bshoot.getBsRemark())) {
				whereHql += " and t.bsRemark = :bsRemark";
				params.put("bsRemark", bshoot.getBsRemark());
			}		
			if (!F.empty(bshoot.getCreatePerson())) {
				whereHql += " and t.createPerson = :createPerson";
				params.put("createPerson", bshoot.getCreatePerson());
			}		
			if (!F.empty(bshoot.getUpdatePerson())) {
				whereHql += " and t.updatePerson = :updatePerson";
				params.put("updatePerson", bshoot.getUpdatePerson());
			}		
		}	
		return whereHql;
	}

	@Override
	public void add(Bshoot bshoot) {
		Tbshoot t = new Tbshoot();
		BeanUtils.copyProperties(bshoot, t);
		if(F.empty(t.getId()))
		t.setId(UUID.randomUUID().toString());
		//t.setCreatedatetime(new Date());
		bshootDao.save(t);
		updateLocation(t);
	}
	
	private void updateLocation(Tbshoot bshoot){
		try{
			if(F.empty(bshoot.getLgX())){
				bshoot.setLgX("0");
			}
			if(F.empty(bshoot.getLgX())){
				bshoot.setLgX("0");
			}
			double x = RoundTool.round(new Double(bshoot.getLgX()), 6, BigDecimal.ROUND_UP);
			double y = RoundTool.round(new Double(bshoot.getLgY()), 6, BigDecimal.ROUND_UP);
			String updateSql = "update bshoot set location=GEOMFROMTEXT('point("+x+" "+y+")') where id = :id";
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", bshoot.getId());
			bshootDao.executeSql(updateSql, params);	
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public Bshoot get(String id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Tbshoot t = bshootDao.get("from Tbshoot t  where t.id = :id", params);
		if(t==null) return null;
		Bshoot o = new Bshoot();
		BeanUtils.copyProperties(t, o);
		return o;
	}

	@Override
	public void edit(Bshoot bshoot) {
		Tbshoot t = bshootDao.get(Tbshoot.class, bshoot.getId());
		if (t != null) {
			BeanUtils.copyProperties(bshoot, t, new String[] { "id" , "createdatetime", "lgX", "lgY" });
			//t.setModifydatetime(new Date());
			updateLocation(t);
		}
	}

	@Override
	public void delete(String id) {
		bshootDao.delete(bshootDao.get(Tbshoot.class, id));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public DataGrid dataGridHot(PageHelper ph) {
		DataGrid dataGrid = dataGrid(null, ph);
		List<Bshoot> bshoots = dataGrid.getRows();
		if(bshoots!=null&&bshoots.size()>0){
			String[] userIds = new String[bshoots.size()];
			int i = 0;
			for(Bshoot b :bshoots){
				userIds[i++] = b.getUserId();
			}
			List<Tuser> list = userDao.getTusers(userIds);
			Map<String,String> map = new HashMap<String,String>();
			for(Tuser t : list){
				map.put(t.getId(), t.getHeadImage());
			}
			for(Bshoot b :bshoots){
				b.setUserHeadImage(map.get(b.getUserId()));
			}
		}
		return dataGrid;
	}
	@Override
	public DataGrid dataGridByCode(PageHelper ph, String code) {
		Bshoot bshoot = new Bshoot();
		bshoot.setBsType(code);
		DataGrid dataGrid = dataGrid(bshoot, ph);
		setUserHeadImage(dataGrid);
		return dataGrid;
	}
	
	private void setUserHeadImage(DataGrid dataGrid){
		List<Bshoot> bshoots = dataGrid.getRows();
		if(bshoots!=null&&bshoots.size()>0){
			String[] userIds = new String[bshoots.size()];
			int i = 0;
			for(Bshoot b :bshoots){
				userIds[i++] = b.getUserId();
			}
			List<Tuser> list = userDao.getTusers(userIds);
			Map<String,String> map = new HashMap<String,String>();
			for(Tuser t : list){
				map.put(t.getId(), t.getHeadImage());
			}
			for(Bshoot b :bshoots){
				b.setUserHeadImage(map.get(b.getUserId()));
			}
		}
	}
	
	@Override
	public DataGrid dataGridNearby(PageHelper ph,String xStr,String yStr) {
		double x = RoundTool.round(new Double(xStr), 6, BigDecimal.ROUND_UP);
		double y = RoundTool.round(new Double(yStr), 6, BigDecimal.ROUND_UP);
		List<Map<String,Object>> list = bshootDao.executeNearby(ph.getPage(), ph.getRows(), x, y);
		DataGrid dataGrid = new DataGrid();
		int i = 0;
		String[] userIds = new String[list.size()];
		for(Map<String,Object> bshoot : list){
			userIds[i++] = (String)bshoot.get("user_id");
		}
		List<Tuser> listUsers = userDao.getTusers(userIds);
		Map<String,String> map = new HashMap<String,String>();
		for(Tuser t : listUsers){
			map.put(t.getId(), t.getHeadImage());
		}
		for(Map<String,Object> b :list){
			b.put("userHeadImage",PathUtil.getHeadImagePath(map.get((String)b.get("user_id"))));
		}
		dataGrid.setRows(list);
		
		return dataGrid;
	}
	@Override
	public DataGrid dataGridByFriend(PageHelper ph, String userId) {
		DataGrid dg = new DataGrid();
		List<Bshoot> ol = new ArrayList<Bshoot>();
		String hql = "select t from Tbshoot t , TuserAttention ua where t.userId = ua.attUserId and ua.userId = :userId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		
		List<Tbshoot> l = bshootDao.find(hql + " order by t.userId", params, ph.getPage(), ph.getRows());
		dg.setTotal(bshootDao.count(hql.replace("select t", "select count(*)") , params));
		if (l != null && l.size() > 0) {
			for (Tbshoot t : l) {
				Bshoot o = new Bshoot();
				BeanUtils.copyProperties(t, o);
				ol.add(o);
			}
		}
		dg.setRows(ol);
		setUserHeadImage(dg);
		return dg;
	}
}
