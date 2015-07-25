package jb.service;

import jb.model.TbshootComment;
import jb.pageModel.BshootComment;
import jb.pageModel.DataGrid;
import jb.pageModel.PageHelper;

/**
 * 
 * @author John
 * 
 */
public interface BshootCommentServiceI {

	/**
	 * 获取BshootComment数据表格
	 * 
	 * @param bshootComment
	 *            参数
	 * @param ph
	 *            分页帮助类
	 * @return
	 */
	public DataGrid dataGrid(BshootComment bshootComment, PageHelper ph);
	
	public DataGrid dataGrid(BshootComment bshootComment, PageHelper ph,String userId);

	/**
	 * 添加BshootComment
	 * 
	 * @param bshootComment
	 */
	
	public TbshootComment add(BshootComment bshootComment);

	/**
	 * 获得BshootComment对象
	 * 
	 * @param id
	 * @return
	 */
	public BshootComment get(String id);

	/**
	 * 修改BshootComment
	 * 
	 * @param bshootComment
	 */
	public void edit(BshootComment bshootComment);

	/**
	 * 删除BshootComment
	 * 
	 * @param id
	 */
	public void delete(String id);

}
