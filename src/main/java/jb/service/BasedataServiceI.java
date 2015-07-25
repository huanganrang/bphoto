package jb.service;

import java.util.List;
import java.util.Map;

import jb.pageModel.BaseData;
import jb.pageModel.DataGrid;
import jb.pageModel.PageHelper;

/**
 * 基础数据业务逻辑
 * 
 * @author John
 * 
 */
public interface BasedataServiceI {

	/**
	 * 保存基础数据
	 * 
	 * @param baseData
	 */
	public void add(BaseData baseData);

	/**
	 * 获得基础数据
	 * 
	 * @param id
	 * @return
	 */
	public BaseData get(String id);

	/**
	 * 编辑基础数据
	 * 
	 * @param baseData
	 */
	public void edit(BaseData baseData);

	/**
	 * 获取BUG数据表格
	 * 
	 * @param baseData
	 *            参数
	 * @param ph
	 *            分页帮助类
	 * @return
	 */
	public DataGrid dataGrid(BaseData baseData, PageHelper ph);

	/**
	 * 删除基础数据
	 * 
	 * @param id
	 */
	public void delete(String id);
	
	/**
	 * 根据类型取基础数据
	 * @param baseType
	 * @return
	 */
	public List<BaseData> getBaseDatas(String baseType);
	
	/**
	 * 获取系统环境变量
	 */
	public Map<String,BaseData> getAppVariable();
	
}
