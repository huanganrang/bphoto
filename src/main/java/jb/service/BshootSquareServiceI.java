package jb.service;

import jb.pageModel.BshootSquare;
import jb.pageModel.DataGrid;
import jb.pageModel.PageHelper;

/**
 * 
 * @author John
 * 
 */
public interface BshootSquareServiceI {

	/**
	 * 获取BshootSquare数据表格
	 * 
	 * @param bshootSquare
	 *            参数
	 * @param ph
	 *            分页帮助类
	 * @return
	 */
	public DataGrid dataGrid(BshootSquare bshootSquare, PageHelper ph);

	/**
	 * 添加BshootSquare
	 * 
	 * @param bshootSquare
	 */
	public void add(BshootSquare bshootSquare);

	/**
	 * 获得BshootSquare对象
	 * 
	 * @param id
	 * @return
	 */
	public BshootSquare get(String id);
	

	/**
	 * 修改BshootSquare
	 * 
	 * @param bshootSquare
	 */
	public void edit(BshootSquare bshootSquare);

	/**
	 * 删除BshootSquare
	 * 
	 * @param id
	 */
	public void delete(String id);

}
