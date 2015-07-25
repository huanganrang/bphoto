package jb.dao.impl;

import jb.dao.ResourceTypeDaoI;
import jb.model.Tresourcetype;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class ResourceTypeDaoImpl extends BaseDaoImpl<Tresourcetype> implements ResourceTypeDaoI {

	@Override
	@Cacheable(value = "resourceTypeDaoCache", key = "#id")
	public Tresourcetype getById(String id) {
		return super.get(Tresourcetype.class, id);
	}

}
