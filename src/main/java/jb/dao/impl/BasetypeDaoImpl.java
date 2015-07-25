package jb.dao.impl;

import jb.dao.BasetypeDaoI;
import jb.model.Tbasetype;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class BasetypeDaoImpl extends BaseDaoImpl<Tbasetype> implements BasetypeDaoI {

	@Override
	@Cacheable(value = "baseTypeDaoCache", key = "#code")
	public Tbasetype getById(String code) {
		return super.get(Tbasetype.class, code);
	}

	

}
