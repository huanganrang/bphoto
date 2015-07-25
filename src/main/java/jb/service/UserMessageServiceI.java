package jb.service;

import jb.pageModel.UserMessage;
import jb.pageModel.DataGrid;
import jb.pageModel.PageHelper;

/**
 * 
 * @author John
 * 
 */
public interface UserMessageServiceI {

	/**
	 * 获取UserMessage数据表格
	 * 
	 * @param userMessage
	 *            参数
	 * @param ph
	 *            分页帮助类
	 * @return
	 */
	public DataGrid dataGrid(UserMessage userMessage, PageHelper ph);

	/**
	 * 添加UserMessage
	 * 
	 * @param userMessage
	 */
	public void add(UserMessage userMessage);

	/**
	 * 获得UserMessage对象
	 * 
	 * @param id
	 * @return
	 */
	public UserMessage get(String id);

	/**
	 * 修改UserMessage
	 * 
	 * @param userMessage
	 */
	public void edit(UserMessage userMessage);

	/**
	 * 删除UserMessage
	 * 
	 * @param id
	 */
	public void delete(String id);

}
