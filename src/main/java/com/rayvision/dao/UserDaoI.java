package com.rayvision.dao;

import java.util.List;

import com.rayvision.model.User;

public interface UserDaoI {
	public int save(User user);
	public int update(User user);
	public int delete(Long id);
	public List<User> findAll();
	public User findById(Long id);
}
