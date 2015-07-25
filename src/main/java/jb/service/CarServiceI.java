package jb.service;

import jb.pageModel.Car;
import jb.pageModel.DataGrid;
import jb.pageModel.PageHelper;

/**
 * 
 * @author John
 * 
 */
public interface CarServiceI {

	/**
	 * 获取Car数据表格
	 * 
	 * @param car
	 *            参数
	 * @param ph
	 *            分页帮助类
	 * @return
	 */
	public DataGrid dataGrid(Car car, PageHelper ph);

	/**
	 * 添加Car
	 * 
	 * @param car
	 */
	public void add(Car car);

	/**
	 * 获得Car对象
	 * 
	 * @param id
	 * @return
	 */
	public Car get(String id);

	/**
	 * 修改Car
	 * 
	 * @param car
	 */
	public void edit(Car car);

	/**
	 * 删除Car
	 * 
	 * @param id
	 */
	public void delete(String id);

}
