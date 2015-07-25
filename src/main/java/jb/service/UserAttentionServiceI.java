package jb.service;

import jb.pageModel.UserAttention;
import jb.pageModel.DataGrid;
import jb.pageModel.PageHelper;

/**
 * 
 * @author John
 * 
 */
public interface UserAttentionServiceI {

	/**
	 * 获取UserAttention数据表格
	 * 
	 * @param userAttention
	 *            参数
	 * @param ph
	 *            分页帮助类
	 * @return
	 */
	public DataGrid dataGrid(UserAttention userAttention, PageHelper ph);
	
	public DataGrid dataGridUser(UserAttention userAttention, PageHelper ph);

	/**
	 * 添加UserAttention
	 * 
	 * @param userAttention
	 */
	public int add(UserAttention userAttention);
	
	/**
	 * 取消关注
	 * @param userAttention
	 */
	public int deleteUa(UserAttention userAttention);

	/**
	 * 获得UserAttention对象
	 * 
	 * @param id
	 * @return
	 */
	public UserAttention get(String id);

	/**
	 * 修改UserAttention
	 * 
	 * @param userAttention
	 */
	public void edit(UserAttention userAttention);

	/**
	 * 删除UserAttention
	 * 
	 * @param id
	 */
	public void delete(String id);
	
	/**
	 * @param userId
	 * @param attUserId
	 * @return
	 */
	public UserAttention get(String userId,String attUserId);

}
