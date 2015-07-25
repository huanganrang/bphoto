package jb.service;

import java.util.List;

import jb.pageModel.DataGrid;
import jb.pageModel.MessageCount;
import jb.pageModel.PageHelper;

/**
 * 
 * @author John
 * 
 */
public interface MessageCountServiceI {

	/**
	 * 获取MessageCount数据表格
	 * 
	 * @param messageCount
	 *            参数
	 * @param ph
	 *            分页帮助类
	 * @return
	 */
	public DataGrid dataGrid(MessageCount messageCount, PageHelper ph);
	
	/**
	 * 获取统计消息
	 * @param messageCount
	 * @return
	 */
	public List<MessageCount> getMessageCounts(MessageCount messageCount);
	
	/**
	 * 删除消息统计
	 * @param userId
	 * @param mtype
	 * @return
	 */
	public boolean deleteMessageCount(String userId,String mtype);
	

	/**
	 * 添加MessageCount
	 * 
	 * @param messageCount
	 */
	public void add(MessageCount messageCount);

	/**
	 * 获得MessageCount对象
	 * 
	 * @param id
	 * @return
	 */
	public MessageCount get(String id);

	/**
	 * 修改MessageCount
	 * 
	 * @param messageCount
	 */
	public void edit(MessageCount messageCount);

	/**
	 * 删除MessageCount
	 * 
	 * @param id
	 */
	public void delete(String id);

}
