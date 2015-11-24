package com.rayvision.service;

import java.util.List;
import java.util.Map;

import com.rayvision.util.Page;

public interface BaseServiceI {
	public int save(Object o);
	public int delete(Class clazz,Long id);
	public int update(Object o);
	public Object findById(Class clazz,Long id);
	public List<Object> findAll(Class clazz);
	public Long count(Class clazz,Map<String, Object> params);
	public Page find(Class clazz, Map<String, Object> params);
	public Map<String,Object> selectMap(Class clazz,Map<String,Object> params);
}
