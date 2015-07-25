package jb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jb.dao.BaseDaoI;
import jb.pageModel.DataGrid;
import jb.pageModel.PageHelper;

public abstract class BaseServiceImpl<T> {
	protected String orderHql(PageHelper ph) {
		String orderString = "";
		if (ph.getSort() != null && ph.getOrder() != null) {
			orderString = " order by t." + ph.getSort() + " " + ph.getOrder();
		}
		return orderString;
	}
	
	protected abstract String whereHql(T t, Map<String, Object> params);
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected DataGrid dataGridQuery(String hql,PageHelper ph,T t,BaseDaoI dao){
		DataGrid dg = new DataGrid();
		Map<String, Object> params = new HashMap<String, Object>();
		String where = whereHql(t, params);
		List<T> l = dao.find(hql  + where + orderHql(ph), params, ph.getPage(), ph.getRows());
		dg.setTotal(dao.count("select count(*) " + hql + where, params));
		dg.setRows(l);
		return dg;
	}
}
