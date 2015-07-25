package jb.service;

import jb.pageModel.Bshoot;
import jb.pageModel.DataGrid;
import jb.pageModel.PageHelper;

/**
 * 
 * @author John
 * 
 */
public interface BshootServiceI {

	/**
	 * 获取Bshoot数据表格
	 * 
	 * @param bshoot
	 *            参数
	 * @param ph
	 *            分页帮助类
	 * @return
	 */
	public DataGrid dataGrid(Bshoot bshoot, PageHelper ph);
	
	
	/**
	 * 热门视频
	 * @param ph
	 * @return
	 */
	public DataGrid dataGridHot(PageHelper ph);
	
	/**
	 * 好友视频
	 * @param ph
	 * @param userId
	 * @return
	 */
	public DataGrid dataGridByFriend(PageHelper ph,String userId);
	
	/**
	 * 附近视频
	 * @param ph
	 * @return
	 */
	public DataGrid dataGridNearby(PageHelper ph,String x,String y);
	
	/**
	 * 根据广场Code查询
	 * @param ph
	 * @param code
	 * @return
	 */
	public DataGrid dataGridByCode(PageHelper ph,String code);
	
	/**
	 * 获取Bshoot数据表格
	 * 
	 * @param bshoot
	 *            参数
	 * @param ph
	 *            分页帮助类
	 * @param qtype    
	 *            查询类别
	 * @return
	 */
	public DataGrid dataGrid(Bshoot bshoot, PageHelper ph,int qtype);
	

	/**
	 * 添加Bshoot
	 * 
	 * @param bshoot
	 */
	public void add(Bshoot bshoot);

	/**
	 * 获得Bshoot对象
	 * 
	 * @param id
	 * @return
	 */
	public Bshoot get(String id);

	/**
	 * 修改Bshoot
	 * 
	 * @param bshoot
	 */
	public void edit(Bshoot bshoot);

	/**
	 * 删除Bshoot
	 * 
	 * @param id
	 */
	public void delete(String id);

}
