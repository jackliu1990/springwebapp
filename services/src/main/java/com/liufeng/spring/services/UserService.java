package com.liufeng.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liufeng.spring.interfaces.IUserService;
import com.liufeng.spring.interfaces.User;

@Service
public class UserService implements IUserService {
	
	private List<User> userlist = new ArrayList<User>();
	
	public UserService(){}
	
	public UserService(String Name){
		
	}
	
	@Override
	public User save(User user) {
		userlist.add(user);
		return user;
	}

	@Override
	public List<User> findAll() {
		return userlist;
	}

	@Override
	public int updateNameById(Long id, String name) {
		return 0;
	}
	
	@Override
	public int del(Long id) {
		return 0;
	}

}
