package jb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import jb.absx.F;
import jb.dao.MessageCountDaoI;
import jb.dao.MessageDaoI;
import jb.model.Tmessage;
import jb.model.TmessageCount;
import jb.pageModel.DataGrid;
import jb.pageModel.Message;
import jb.pageModel.PageHelper;
import jb.service.MessageServiceI;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends BaseServiceImpl<Message> implements MessageServiceI {

	@Autowired
	private MessageDaoI messageDao;
	@Autowired
	private MessageCountDaoI messageCountDao;

	@Override
	public DataGrid dataGrid(Message message, PageHelper ph) {
		List<Message> ol = new ArrayList<Message>();
		String hql = " from Tmessage t ";
		DataGrid dg = dataGridQuery(hql, ph, message, messageDao);
		@SuppressWarnings("unchecked")
		List<Tmessage> l = dg.getRows();
		if (l != null && l.size() > 0) {
			for (Tmessage t : l) {
				Message o = new Message();
				BeanUtils.copyProperties(t, o);
				ol.add(o);
			}
		}
		dg.setRows(ol);
		return dg;
	}
	

	protected String whereHql(Message message, Map<String, Object> params) {
		String whereHql = "";	
		if (message != null) {
			whereHql += " where 1=1 ";
			if (!F.empty(message.getMtype())) {
				whereHql += " and t.mtype = :mtype";
				params.put("mtype", message.getMtype());
			}		
			if (!F.empty(message.getUserId())) {
				whereHql += " and t.userId = :userId";
				params.put("userId", message.getUserId());
			}		
			if (message.getIsRead()!=null) {
				whereHql += " and t.isRead = :isRead";
				params.put("isRead", message.getIsRead());
			}		
			if (!F.empty(message.getRelationId())) {
				whereHql += " and t.relationId = :relationId";
				params.put("relationId", message.getRelationId());
			}		
			if (!F.empty(message.getContent())) {
				whereHql += " and t.content = :content";
				params.put("content", message.getContent());
			}		
		}	
		return whereHql;
	}

	@Override
	public void add(Message message) {
		Tmessage t = new Tmessage();
		BeanUtils.copyProperties(message, t);
		t.setId(UUID.randomUUID().toString());
		//t.setCreatedatetime(new Date());
		messageDao.save(t);
	}

	@Override
	public Message get(String id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Tmessage t = messageDao.get("from Tmessage t  where t.id = :id", params);
		Message o = new Message();
		BeanUtils.copyProperties(t, o);
		return o;
	}

	@Override
	public void edit(Message message) {
		Tmessage t = messageDao.get(Tmessage.class, message.getId());
		if (t != null) {
			BeanUtils.copyProperties(message, t, new String[] { "id" , "createdatetime" });
			//t.setModifydatetime(new Date());
		}
	}

	@Override
	public void delete(String id) {
		messageDao.delete(messageDao.get(Tmessage.class, id));
	}


	@Override
	public TmessageCount addAndCount(Message message) {
		Tmessage t = new Tmessage();
		BeanUtils.copyProperties(message, t);
		t.setId(UUID.randomUUID().toString());
		t.setCreatedatetime(new Date());
		messageDao.save(t);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mtype", message.getMtype());
		params.put("userId", message.getUserId());
		List<TmessageCount> messageCounts = messageCountDao.find("from TmessageCount t where t.mtype =:mtype and t.userId = :userId",params);
		if(messageCounts!=null&&messageCounts.size()>0){
			TmessageCount tmessageCount = messageCounts.get(0);
			tmessageCount.setMnumber(tmessageCount.getMnumber()+1);
			messageCountDao.saveOrUpdate(tmessageCount);
			return tmessageCount;
		}else{
			TmessageCount tmessageCount = new TmessageCount();
			tmessageCount.setId(UUID.randomUUID().toString());
			tmessageCount.setMnumber(1);
			tmessageCount.setMtype(message.getMtype());
			tmessageCount.setUserId(message.getUserId());
			messageCountDao.saveOrUpdate(tmessageCount);
			return tmessageCount;
				
		}	
	}

}
