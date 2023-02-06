package com.service;

import java.util.List;

import com.model.UserInfo;



public interface UserService {
	
	public void addUser(UserInfo user);
	public List<UserInfo> getAllUsers();
	public UserInfo getById (Integer id);
	public void  deleteUser(Integer id);
	public void updateUser(UserInfo user);	
	
	

}
