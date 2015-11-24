package com.rayvision.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rayvision.util.Page;

@Repository
public class BaseDao implements BaseDaoI{
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	public int save(Object o){				
		int result=sqlSessionFactory.openSession().insert(o.getClass().getName()+".save", o);
		sqlSessionFactory.openSession().commit();
		return result;
	}
	public int delete(Class clazz,Long id) {
		System.out.println(clazz.getName());
		int result=sqlSessionFactory.openSession().delete(clazz.getName()+".delete", id);
		sqlSessionFactory.openSession().commit();
		return result;
	}
	public int update(Object o) {
		int result=sqlSessionFactory.openSession().update(o.getClass().getName()+".update", o);
		sqlSessionFactory.openSession().commit();
		return result;
	}
	public Object findById(Class clazz,Long id) {
		Object o=sqlSessionFactory.openSession().selectOne(clazz.getName()+".findById", id);		
		return o;
	}
	public List<Object> findAll(Class clazz) {
		List<Object> list=sqlSessionFactory.openSession().selectList(clazz.getName()+".findAll");		
		return list;
	}
	public Long count(Class clazz,Map<String, Object> params){
		Long count=Long.valueOf(sqlSessionFactory.openSession().selectList(clazz.getName()+".count",params).size());
		return count;
	}
	@Override
	public Page find(Class clazz,Map<String, Object> params) {
		Page page=new Page(params);
		params.put("start", page.getStart());
		params.put("limit",page.getLimit());
		List<Object> list=sqlSessionFactory.openSession().selectList(clazz.getName()+".find",params);			
		page.setTotalCount(count(clazz,params));
		page.setResult(list);
		return page;
	}
	@Override
	public Map<String,Object> selectMap(Class clazz, Map<String, Object> params) {
		// TODO Auto-generated method stub
		Map<String,Object>  map=sqlSessionFactory.openSession().selectMap(clazz.getName()+".selectMap", params, "id");
		return map;
	}
	
	
}
