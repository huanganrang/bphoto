package jb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import jb.absx.F;
import jb.dao.UserMessageDaoI;
import jb.model.TuserMessage;
import jb.pageModel.UserMessage;
import jb.pageModel.DataGrid;
import jb.pageModel.PageHelper;
import jb.service.UserMessageServiceI;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMessageServiceImpl extends BaseServiceImpl<UserMessage> implements UserMessageServiceI {

	@Autowired
	private UserMessageDaoI userMessageDao;

	@Override
	public DataGrid dataGrid(UserMessage userMessage, PageHelper ph) {
		List<UserMessage> ol = new ArrayList<UserMessage>();
		String hql = " from TuserMessage t ";
		DataGrid dg = dataGridQuery(hql, ph, userMessage, userMessageDao);
		@SuppressWarnings("unchecked")
		List<TuserMessage> l = dg.getRows();
		if (l != null && l.size() > 0) {
			for (TuserMessage t : l) {
				UserMessage o = new UserMessage();
				BeanUtils.copyProperties(t, o);
				ol.add(o);
			}
		}
		dg.setRows(ol);
		return dg;
	}
	

	protected String whereHql(UserMessage userMessage, Map<String, Object> params) {
		String whereHql = "";	
		if (userMessage != null) {
			whereHql += " where 1=1 ";
			if (!F.empty(userMessage.getUserId())) {
				whereHql += " and t.userId = :userId";
				params.put("userId", userMessage.getUserId());
			}		
			if (!F.empty(userMessage.getUmType())) {
				whereHql += " and t.umType = :umType";
				params.put("umType", userMessage.getUmType());
			}		
			if (!F.empty(userMessage.getUmMessage())) {
				whereHql += " and t.umMessage = :umMessage";
				params.put("umMessage", userMessage.getUmMessage());
			}		
			if (!F.empty(userMessage.getUmRemark())) {
				whereHql += " and t.umRemark = :umRemark";
				params.put("umRemark", userMessage.getUmRemark());
			}		
			if (!F.empty(userMessage.getCreatePerson())) {
				whereHql += " and t.createPerson = :createPerson";
				params.put("createPerson", userMessage.getCreatePerson());
			}		
			if (!F.empty(userMessage.getUpdatePerson())) {
				whereHql += " and t.updatePerson = :updatePerson";
				params.put("updatePerson", userMessage.getUpdatePerson());
			}		
		}	
		return whereHql;
	}

	@Override
	public void add(UserMessage userMessage) {
		TuserMessage t = new TuserMessage();
		BeanUtils.copyProperties(userMessage, t);
		t.setId(UUID.randomUUID().toString());
		//t.setCreatedatetime(new Date());
		userMessageDao.save(t);
	}

	@Override
	public UserMessage get(String id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		TuserMessage t = userMessageDao.get("from TuserMessage t  where t.id = :id", params);
		UserMessage o = new UserMessage();
		BeanUtils.copyProperties(t, o);
		return o;
	}

	@Override
	public void edit(UserMessage userMessage) {
		TuserMessage t = userMessageDao.get(TuserMessage.class, userMessage.getId());
		if (t != null) {
			BeanUtils.copyProperties(userMessage, t, new String[] { "id" , "createdatetime" });
			//t.setModifydatetime(new Date());
		}
	}

	@Override
	public void delete(String id) {
		userMessageDao.delete(userMessageDao.get(TuserMessage.class, id));
	}

}
