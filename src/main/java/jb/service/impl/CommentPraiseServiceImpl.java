package jb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import jb.absx.F;
import jb.dao.CommentPraiseDaoI;
import jb.model.TbshootPraise;
import jb.model.TcommentPraise;
import jb.pageModel.BshootPraise;
import jb.pageModel.CommentPraise;
import jb.pageModel.DataGrid;
import jb.pageModel.PageHelper;
import jb.service.CommentPraiseServiceI;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentPraiseServiceImpl extends BaseServiceImpl<CommentPraise> implements CommentPraiseServiceI {

	@Autowired
	private CommentPraiseDaoI commentPraiseDao;

	@Override
	public DataGrid dataGrid(CommentPraise commentPraise, PageHelper ph) {
		List<CommentPraise> ol = new ArrayList<CommentPraise>();
		String hql = " from TcommentPraise t ";
		DataGrid dg = dataGridQuery(hql, ph, commentPraise, commentPraiseDao);
		@SuppressWarnings("unchecked")
		List<TcommentPraise> l = dg.getRows();
		if (l != null && l.size() > 0) {
			for (TcommentPraise t : l) {
				CommentPraise o = new CommentPraise();
				BeanUtils.copyProperties(t, o);
				ol.add(o);
			}
		}
		dg.setRows(ol);
		return dg;
	}
	

	protected String whereHql(CommentPraise commentPraise, Map<String, Object> params) {
		String whereHql = "";	
		if (commentPraise != null) {
			whereHql += " where 1=1 ";
			if (!F.empty(commentPraise.getCommentId())) {
				whereHql += " and t.commentId = :commentId";
				params.put("commentId", commentPraise.getCommentId());
			}		
			if (!F.empty(commentPraise.getUserId())) {
				whereHql += " and t.userId = :userId";
				params.put("userId", commentPraise.getUserId());
			}		
		}	
		return whereHql;
	}

	@Override
	public int add(CommentPraise commentPraise) {		
		if(get(commentPraise.getCommentId(), commentPraise.getUserId())!=null)
			return -1;
		TcommentPraise t = new TcommentPraise();
		BeanUtils.copyProperties(commentPraise, t);
		t.setId(UUID.randomUUID().toString());
		//t.setCreatedatetime(new Date());
		t.setPraiseDatetime(new Date());
		commentPraiseDao.save(t);
		updateCount(commentPraise.getCommentId());
		return 1;
	}
	private void updateCount(String commentId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("commentId", commentId);
		params.put("id", commentId);
		commentPraiseDao.executeSql("update bshoot_comment t set t.comment_praise = (select count(*)+1 from comment_praise b where b.comment_id =:commentId) where t.id=:id", params);
	}

	private void updateCountReduce(String commentId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("commentId", commentId);
		params.put("id", commentId);
		commentPraiseDao.executeSql("update bshoot_comment t set t.comment_praise = (select count(*)-1 from comment_praise b where b.comment_id =:commentId) where t.id=:id", params);
	}
	public CommentPraise get(String commentId, String userId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("commentId", commentId);
		params.put("userId", userId);
		TcommentPraise t = commentPraiseDao.get("from TcommentPraise t  where t.commentId = :commentId and t.userId = :userId", params);
		if(t==null)return null;
		CommentPraise o = new CommentPraise();
		BeanUtils.copyProperties(t, o);
		return o;
	}

	@Override
	public CommentPraise get(String id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		TcommentPraise t = commentPraiseDao.get("from TcommentPraise t  where t.id = :id", params);
		CommentPraise o = new CommentPraise();
		BeanUtils.copyProperties(t, o);
		return o;
	}

	@Override
	public void edit(CommentPraise commentPraise) {
		TcommentPraise t = commentPraiseDao.get(TcommentPraise.class, commentPraise.getId());
		if (t != null) {
			BeanUtils.copyProperties(commentPraise, t, new String[] { "id" , "createdatetime" });
			//t.setModifydatetime(new Date());
		}
	}

	@Override
	public void delete(String id) {
		TcommentPraise t = commentPraiseDao.get(TcommentPraise.class, id);
		commentPraiseDao.delete(t);
		updateCountReduce(t.getCommentId());
	}


	@Override
	public int deleteCommentPraise(CommentPraise commentPraise) {
		CommentPraise bc = get(commentPraise.getCommentId(), commentPraise.getUserId());
		if(bc==null){
			return -1;
		}else{
			delete(bc.getId());
		}
		return 0;
	}

}
