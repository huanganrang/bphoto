package jb.service.impl;

import java.util.ArrayList;
import java.util.List;

import jb.dao.BasetypeDaoI;
import jb.model.Tbasetype;
import jb.pageModel.BaseType;
import jb.service.BasetypeServiceI;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasetypeServiceImpl implements BasetypeServiceI {

	@Autowired
	private BasetypeDaoI basetypeDao;
	@Override
	public void add(BaseType baseType) {
		Tbasetype bt = new Tbasetype();
		BeanUtils.copyProperties(baseType, bt);
		basetypeDao.save(bt);

	}

	@Override
	public BaseType get(String id) {
		BaseType bt  = new BaseType();
		Tbasetype tbt = basetypeDao.get(Tbasetype.class, id);
		BeanUtils.copyProperties(tbt, bt);
		return bt;
	}

	@Override
	public void edit(BaseType basetype) {
		Tbasetype tbt = basetypeDao.get(Tbasetype.class, basetype.getCode());
		if(tbt!=null)
		BeanUtils.copyProperties(basetype, tbt,new String[]{"code","type"});
	}

	@Override
	public List<BaseType> treeGrid() {
		List<Tbasetype> tbasetypes = basetypeDao.find(" from Tbasetype t order by t.type");
		List<BaseType> basetypes = new ArrayList<BaseType>();
		for(Tbasetype t : tbasetypes){
			BaseType bt = new BaseType();
			BeanUtils.copyProperties(t, bt);
			basetypes.add(bt);
		}
		return basetypes;
	}

	@Override
	public void delete(String id) {
		Tbasetype tbt = basetypeDao.get(Tbasetype.class, id);
		if(tbt!=null)
			basetypeDao.delete(tbt);
	}
}
