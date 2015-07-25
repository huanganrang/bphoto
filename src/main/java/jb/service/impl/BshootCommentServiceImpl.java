package jb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import jb.absx.F;
import jb.dao.BshootCommentDaoI;
import jb.dao.CommentPraiseDaoI;
import jb.model.TbshootComment;
import jb.model.TcommentPraise;
import jb.pageModel.BshootComment;
import jb.pageModel.DataGrid;
import jb.pageModel.PageHelper;
import jb.service.BshootCommentServiceI;
import jb.util.Constants;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BshootCommentServiceImpl extends BaseServiceImpl<BshootComment> implements BshootCommentServiceI {

	@Autowired
	private BshootCommentDaoI bshootCommentDao;
	
	@Autowired
	private CommentPraiseDaoI commentPraiseDao;

	@Override
	public DataGrid dataGrid(BshootComment bshootComment, PageHelper ph) {
		List<BshootComment> ol = new ArrayList<BshootComment>();
		String hql = " from TbshootComment t ";
		DataGrid dg = dataGridQuery(hql, ph, bshootComment, bshootCommentDao);
		@SuppressWarnings("unchecked")
		List<TbshootComment> l = dg.getRows();
		if (l != null && l.size() > 0) {
			for (TbshootComment t : l) {
				BshootComment o = new BshootComment();
				BeanUtils.copyProperties(t, o);
				ol.add(o);
			}
		}
		dg.setRows(ol);
		return dg;
	}
	

	protected String whereHql(BshootComment bshootComment, Map<String, Object> params) {
		String whereHql = "";	
		if (bshootComment != null) {
			whereHql += " where 1=1 ";
			if (!F.empty(bshootComment.getUserId())) {
				whereHql += " and t.userId = :userId";
				params.put("userId", bshootComment.getUserId());
			}		
			if (!F.empty(bshootComment.getBshootId())) {
				whereHql += " and t.bshootId = :bshootId";
				params.put("bshootId", bshootComment.getBshootId());
			}		
			if (!F.empty(bshootComment.getParentId())) {
				whereHql += " and t.parentId = :parentId";
				params.put("parentId", bshootComment.getParentId());
			}		
			if (!F.empty(bshootComment.getBsCommentText())) {
				whereHql += " and t.bsCommentText = :bsCommentText";
				params.put("bsCommentText", bshootComment.getBsCommentText());
			}		
		}	
		return whereHql;
	}

	@Override
	public TbshootComment add(BshootComment bshootComment) {
		TbshootComment t = new TbshootComment();
		BeanUtils.copyProperties(bshootComment, t);
		t.setId(UUID.randomUUID().toString());
		t.setCommentDatetime(new Date());
		bshootCommentDao.save(t);
		return t;
	}

	@Override
	public BshootComment get(String id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		TbshootComment t = bshootCommentDao.get("from TbshootComment t  where t.id = :id", params);
		BshootComment o = new BshootComment();
		BeanUtils.copyProperties(t, o);
		return o;
	}

	@Override
	public void edit(BshootComment bshootComment) {
		TbshootComment t = bshootCommentDao.get(TbshootComment.class, bshootComment.getId());
		if (t != null) {
			BeanUtils.copyProperties(bshootComment, t, new String[] { "id" , "createdatetime" });
			//t.setModifydatetime(new Date());
		}
	}

	@Override
	public void delete(String id) {
		bshootCommentDao.delete(bshootCommentDao.get(TbshootComment.class, id));
	}


	@Override
	public DataGrid dataGrid(BshootComment bshootComment, PageHelper ph,
			String userId) {
		DataGrid dataGrid = dataGrid(bshootComment, ph);
		List<BshootComment> bshootComments = dataGrid.getRows();
		if(bshootComments!=null&&bshootComments.size()>0){
			String[] commentIds = new String[bshootComments.size()];
			int i = 0;
			for(BshootComment b :bshootComments){
				commentIds[i++] = b.getId();
			}
			List<TcommentPraise> list = commentPraiseDao.getTcommentPraises(userId, commentIds);
			Map<String,String> map = new HashMap<String,String>();
			for(TcommentPraise t : list){
				map.put(t.getCommentId(), t.getCommentId());
			}
			for(BshootComment b :bshootComments){
				if(map.get(b.getId())!=null){
					b.setPraised(Constants.GLOBAL_BOOLEAN_TRUE);
				}else{
					b.setPraised(Constants.GLOBAL_BOOLEAN_FALSE);
				}
			}
		}	
		return dataGrid;
	}

}
