package com.rayvision.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rayvision.controller.base.BaseController;
import com.rayvision.model.Role;

@Controller
@RequestMapping("/role")
public class Roles extends BaseController {
	@RequestMapping(value="/save", method=RequestMethod.POST)	
	public void save(Role role){
		_Save(role);		
	}
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public void delete(String id){		
		_Delete(Role.class,id);			
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public void update(Role role){
		_Update(role);		
	}
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public void search(){
		_Seacrh(Role.class);
	}
	@RequestMapping(value="/show", method=RequestMethod.POST)
	public Role show(Long id){
		return (Role)_findById(Role.class,id);		
	}
}
