package com.service;

import java.util.List;

import com.model.UserInfo;



public interface UserService {
	
	public void addUser(UserInfo user);
	public List<UserInfo> getAllUsers();
	public UserInfo getById (Long id);
	public void  deleteUser(Long id);
	public void updateUser(UserInfo user);	
	public void deleteUserRole(Long id);
	public UserInfo findByUserName(String userName);
	public void registration(UserInfo user);
	

}
