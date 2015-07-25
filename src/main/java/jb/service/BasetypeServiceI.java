package jb.service;

import java.util.List;

import jb.pageModel.BaseType;

/**
 * 基础数据类型业务逻辑
 * 
 * @author John
 * 
 */
public interface BasetypeServiceI {

	/**
	 * 保存基础数据类型
	 * 
	 * @param baseType
	 */
	public void add(BaseType baseType);

	/**
	 * 获得基础数据类型
	 * 
	 * @param id
	 * @return
	 */
	public BaseType get(String id);

	/**
	 * 编辑基础数据类型
	 * 
	 * @param baseType
	 */
	public void edit(BaseType basetype);

	/**
	 * 获得角色treeGrid
	 * 
	 * @return
	 */
	public List<BaseType> treeGrid();

	/**
	 * 删除基础数据类型
	 * 
	 * @param id
	 */
	public void delete(String id);


}
