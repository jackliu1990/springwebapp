package com.liufeng.spring.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	 @RequestMapping("/tile/{z}/{x}/{y}.png")
	 public byte[] getTile(@PathVariable int z,@PathVariable int x,@PathVariable int y,HttpServletResponse response){
		 response.setContentType("image/png");
		 String path = "/home/liufeng/workspace/testmapnik/output/"+z+"/"+x+"_"+y+".png";
	     return getContent(path);
	 }
	 
	 private byte[] getContent(String path){
		 File file = new File(path);
		 if(!file.exists()||file.isDirectory())
			 return null;
		 byte[] content = null;
		 try{
			 BufferedInputStream instream = new BufferedInputStream(new FileInputStream(file));
			 int len  =instream.available();
			 content = new byte[len];
			 instream.read(content);
			 instream.close();
			 return content;		 
		 }catch(IOException e){
			 e.printStackTrace();
			 throw new RuntimeException(e);
		 }
	 }

}
