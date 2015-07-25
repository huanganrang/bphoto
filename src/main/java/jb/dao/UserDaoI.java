package jb.dao;

import java.util.List;

import jb.model.Tuser;

/**
 * 用户数据库操作类
 * 
 * @author John
 * 
 */
public interface UserDaoI extends BaseDaoI<Tuser> {
	public List<Tuser> getTusers(String ...userids);
}
