package jb.dao;

import java.util.List;

import jb.model.TcommentPraise;

/**
 * CommentPraise数据库操作类
 * 
 * @author John
 * 
 */
public interface CommentPraiseDaoI extends BaseDaoI<TcommentPraise> {
	public List<TcommentPraise> getTcommentPraises(String userId,String[] commentIds);
}
