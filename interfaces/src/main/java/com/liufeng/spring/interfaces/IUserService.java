package com.liufeng.spring.interfaces;

import java.util.List;

public interface IUserService {
	
	User save(User user);
	
	List<User> findAll();
	
	int updateNameById(Long id, String name);
	
	int del(Long id);
}
