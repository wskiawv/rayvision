package com.rayvision.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rayvision.model.User;
import com.rayvision.controller.base.BaseController;
@Controller
@RequestMapping("/user")
public class Users extends BaseController{
	@RequestMapping(value="/save", method=RequestMethod.POST)	
	public void save(User user){
		_Save(user);		
	}
	@RequestMapping(value="/success", method=RequestMethod.POST)	
	public String success(){
		System.out.println("success");
		return "main";
	}
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public void index(){
		
	}
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public void delete(String id){		
		_Delete(User.class,id);	
		
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public void update(User user){
		_Update(user);		
	}
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public void search(){
		_Seacrh(User.class);
	}
	@RequestMapping(value="/show", method=RequestMethod.POST)
	public User show(Long id){
		return (User)_findById(User.class,id);		
	}
}
