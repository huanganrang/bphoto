package jb.service;

import jb.pageModel.BshootToSquare;
import jb.pageModel.DataGrid;
import jb.pageModel.PageHelper;

/**
 * 
 * @author John
 * 
 */
public interface BshootToSquareServiceI {

	/**
	 * 获取BshootToSquare数据表格
	 * 
	 * @param bshootToSquare
	 *            参数
	 * @param ph
	 *            分页帮助类
	 * @return
	 */
	public DataGrid dataGrid(BshootToSquare bshootToSquare, PageHelper ph);

	/**
	 * 添加BshootToSquare
	 * 
	 * @param bshootToSquare
	 */
	public void add(BshootToSquare bshootToSquare);
	
	/**
	 * 用户提交投稿
	 * 
	 * @param bshootToSquare
	 */
	public int addFromUser(BshootToSquare bshootToSquare);

	/**
	 * 获得BshootToSquare对象
	 * 
	 * @param id
	 * @return
	 */
	public BshootToSquare get(String id);

	/**
	 * 修改BshootToSquare
	 * 
	 * @param bshootToSquare
	 */
	public void edit(BshootToSquare bshootToSquare);

	/**
	 * 删除BshootToSquare
	 * 
	 * @param id
	 */
	public void delete(String id);

}
