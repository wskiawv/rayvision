package com.rayvision.service;

import java.util.List;

import com.rayvision.model.User;

public interface UserServiceI {
	public int save(User user);
	public int update(User user);
	public int delete(Long id);
	public List<User> findAll();
	public User findById(Long id);
}
