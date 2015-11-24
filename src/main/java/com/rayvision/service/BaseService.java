package com.rayvision.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rayvision.dao.BaseDaoI;
import com.rayvision.util.Page;


@Service
public class BaseService implements BaseServiceI {
	@Autowired
	private BaseDaoI baseDao;
	@Override
	public int save(Object o) {	
		return baseDao.save(o);
	}

	@Override
	public int delete(Class clazz,Long id) {		
		return baseDao.delete(clazz,id);
	}

	@Override
	public int update(Object o) {		
		return baseDao.update(o);
	}

	@Override
	public Object findById(Class clazz,Long id) {		
		return baseDao.findById(clazz,id);
	}
	
	@Override
	public List<Object> findAll(Class clazz) {		
		return baseDao.findAll(clazz);
	}

	@Override
	public Long count(Class clazz,Map<String, Object> params) {		
		return baseDao.count(clazz,params);
	}

	@Override
	public Page find(Class clazz,Map<String, Object> params) {
		// TODO Auto-generated method stub
		return baseDao.find(clazz,params);
	}

	@Override
	public Map<String, Object> selectMap(Class clazz, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return baseDao.selectMap(clazz, params);
	}
	
}
