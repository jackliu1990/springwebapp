package com.liufeng.spring.interfaces;

public class User {
    private String Name;
    public User(String Name){
    	this.Name =Name;
    }
    
    public String getName(){
    	return this.Name;
    }
    
    public void setName(String Name){
    	this.Name =Name;
    }
}
