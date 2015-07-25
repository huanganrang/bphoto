package jb.service;

import java.util.List;

import jb.pageModel.ResourceType;

/**
 * 资源类型服务
 * 
 * @author John
 * 
 */
public interface ResourceTypeServiceI {

	/**
	 * 获取资源类型
	 * 
	 * @return
	 */
	public List<ResourceType> getResourceTypeList();

}
