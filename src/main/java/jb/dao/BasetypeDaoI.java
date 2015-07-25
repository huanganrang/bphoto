package jb.dao;

import jb.model.Tbasetype;

/**
 * basetype数据库操作类
 * 
 * @author John
 * 
 */
public interface BasetypeDaoI extends BaseDaoI<Tbasetype>  {
	
	/**
	 * 通过主键获取类型
	 * @param code
	 * @return
	 */
	public Tbasetype getById(String code);
}
