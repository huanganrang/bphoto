package jb.service;

import jb.pageModel.CommentPraise;
import jb.pageModel.DataGrid;
import jb.pageModel.PageHelper;

/**
 * 
 * @author John
 * 
 */
public interface CommentPraiseServiceI {

	/**
	 * 获取CommentPraise数据表格
	 * 
	 * @param commentPraise
	 *            参数
	 * @param ph
	 *            分页帮助类
	 * @return
	 */
	public DataGrid dataGrid(CommentPraise commentPraise, PageHelper ph);

	/**
	 * 添加CommentPraise
	 * 
	 * @param commentPraise
	 */
	public int add(CommentPraise commentPraise);
	
	/**
	 * 取消评论赞
	 * @param commentPraise
	 * @return
	 */
	public int deleteCommentPraise(CommentPraise commentPraise);

	/**
	 * 获得CommentPraise对象
	 * 
	 * @param id
	 * @return
	 */
	public CommentPraise get(String id);

	/**
	 * 修改CommentPraise
	 * 
	 * @param commentPraise
	 */
	public void edit(CommentPraise commentPraise);

	/**
	 * 删除CommentPraise
	 * 
	 * @param id
	 */
	public void delete(String id);

}
