package jb.service;

import jb.model.TmessageCount;
import jb.pageModel.DataGrid;
import jb.pageModel.Message;
import jb.pageModel.PageHelper;

/**
 * 
 * @author John
 * 
 */
public interface MessageServiceI {

	/**
	 * 获取Message数据表格
	 * 
	 * @param message
	 *            参数
	 * @param ph
	 *            分页帮助类
	 * @return
	 */
	public DataGrid dataGrid(Message message, PageHelper ph);

	/**
	 * 添加Message
	 * 
	 * @param message
	 */
	public void add(Message message);
	
	/**
	 * 添加Message
	 * @param message
	 */
	public TmessageCount addAndCount(Message message);

	/**
	 * 获得Message对象
	 * 
	 * @param id
	 * @return
	 */
	public Message get(String id);

	/**
	 * 修改Message
	 * 
	 * @param message
	 */
	public void edit(Message message);

	/**
	 * 删除Message
	 * 
	 * @param id
	 */
	public void delete(String id);

}
