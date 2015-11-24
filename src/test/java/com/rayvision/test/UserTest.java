package com.rayvision.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rayvision.model.User;
import com.rayvision.service.UserServiceI;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class UserTest {
	@Autowired
	public UserServiceI userService;
	@Test
	public void addUser(){
		User user=new User();
		user.setUsername("he");
		user.setPassword("123456");
		userService.save(user);
	}
	@Test
	public void findAll(){
		List<User>userList=userService.findAll();
		for(User u:userList){
			System.out.println(u.getUsername());
			System.out.println(u.getPassword());
		}
	}
/*	@Test
	public void update(){
		Long l=(long)2;
		User user=userService.findById(l);
		user.setPassword("654321");
		userService.update(user);
	}*/
	/*@Test
	public void delete(){
		Long l=(long) 1;
		userService.delete(l);
	}*/
}
