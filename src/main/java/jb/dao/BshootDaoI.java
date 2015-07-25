package jb.dao;

import java.util.List;
import java.util.Map;

import jb.model.Tbshoot;

/**
 * Bshoot数据库操作类
 * 
 * @author John
 * 
 */
public interface BshootDaoI extends BaseDaoI<Tbshoot> {
	public List<Map<String,Object>> executeNearby(int page, int rows,double lgx,double lgy);
}
