package com.liufeng.spring.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liufeng.spring.interfaces.IUserService;
import com.liufeng.spring.interfaces.User;

@RestController
public class UserController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping("/user/findAll")
	 public List<User> hello(String name) {
		return  userService.findAll();
	 }

	@RequestMapping("/user/save")
	 public User save(String name) {
		User u = new User(name);
		//u.setName(name);
		return userService.save(u);
	 }

	@RequestMapping("/user/updateNameById")
	 public int updateNameById(Long id, String name) {
		return userService.updateNameById(id, name);
	 }

	@RequestMapping("/user/del")
	 public int del(Long id) {
		return userService.del(id);
	 }
}
