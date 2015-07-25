package jb.dao.impl;

import java.util.List;

import jb.dao.CommentPraiseDaoI;
import jb.model.TcommentPraise;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CommentPraiseDaoImpl extends BaseDaoImpl<TcommentPraise> implements CommentPraiseDaoI {
	@SuppressWarnings("unchecked")
	@Override
	public List<TcommentPraise> getTcommentPraises(String userId,String[] commentIds) {
		if(commentIds==null||commentIds.length==0)return null;
		String hql="FROM TcommentPraise t WHERE t.commentId in (:alist) and t.userId = :userId";  
		Query query = getCurrentSession().createQuery(hql);  
		query.setParameterList("alist", commentIds); 
		query.setParameter("userId", userId);
		List<TcommentPraise> l = query.list();
		return l;
	}
}
