package com.rayvision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rayvision.dao.UserDaoI;
import com.rayvision.model.User;
@Service
public class UserService implements UserServiceI {
	@Autowired
	private UserDaoI userDao;
	@Override
	public int save(User user) {		
		return userDao.save(user);
	}
	@Override
	public int update(User user) {		
		return userDao.update(user);
	}

	@Override
	public int delete(Long id) {		
		return userDao.delete(id);
	}

	@Override
	public List<User> findAll() {		
		return userDao.findAll();
	}
	@Override
	public User findById(Long id) {		
		return userDao.findById(id);
	}

}
