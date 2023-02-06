package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserRepo;
import com.model.UserInfo;
@Service
public class UserInfoImpl implements UserService{

	@Autowired
	UserRepo repo;
	
	@Override
	public void addUser(UserInfo info) {
		repo.save(info);
		
	}

	@Override
	public List<UserInfo> getAllUsers() {
	
		return repo.findAll();
	}

	@Override
	public UserInfo getById(Long id) {
	
		return repo.findById(id).get();
	}

	@Override
	public void deleteUser(Long id) {
	repo.deleteById(id);
		
	}

	@Override
	public void updateUser(UserInfo user) {
	repo.save(user);
		
	}

	@Override
	public void deleteUserRole(Long id) {
		repo.deleteUserRole(id);
		
	}

}
