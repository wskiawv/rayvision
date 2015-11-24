package com.rayvision.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rayvision.model.User;
@Repository
public class UserDao implements UserDaoI {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Override
	public int save(User user) {
		System.out.println(user.getClass());
		int result=sqlSessionFactory.openSession().insert("com.rayvision.model.User.save", user);
		return result;
	}

	@Override
	public int update(User user) {
		int result=sqlSessionFactory.openSession().update("update",user);
		return result;
	}

	@Override
	public int delete(Long id) {
		int result=sqlSessionFactory.openSession().delete("delete", id);
		return result;
	}

	@Override
	public List<User> findAll() {
		List<User> userList=sqlSessionFactory.openSession().selectList("findAll",User.class);
		return userList;
	}

	@Override
	public User findById(Long id) {
		User user=sqlSessionFactory.openSession().selectOne("findById", id);
		return user;
	}

}
