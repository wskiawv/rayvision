package com.rayvision.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rayvision.model.Role;
import com.rayvision.model.User;
import com.rayvision.service.BaseServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class TestBaseService {
	@Autowired
	public BaseServiceI baseService;
	
	/*@Test
	public void addRole(){
		Role role =new Role();
		role.setName("管理员");		
		baseService.save(role);
	}
	@Test
	public void findById(){
		Role role=(Role)baseService.findById(Role.class, (long)1);
		System.out.println(role.getName());
	}*/
	/*@Test
	public void addUser(){
		User user=new User();
		user.setUsername("he");
		user.setPassword("123456");
		baseService.save(user);
	}*/
	@Test
	public void selectMap(){
		Map<String,Object> params=new HashMap();
		params.put("username", "he");
		Map<String,Object> map=baseService.selectMap(User.class, params);
		System.out.println(map.get("table"));
		System.out.println(map);
	}
}
