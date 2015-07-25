package jb.service.impl;

import java.util.List;

import jb.dao.BugTypeDaoI;
import jb.model.Tbugtype;
import jb.service.BugTypeServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BugTypeServiceImpl implements BugTypeServiceI {

	@Autowired
	private BugTypeDaoI bugType;

	@Override
	@Cacheable(value = "bugTypeServiceCache", key = "'bugTypeList'")
	public List<Tbugtype> getBugTypeList() {
		return bugType.find("from Tbugtype t");
	}

}
