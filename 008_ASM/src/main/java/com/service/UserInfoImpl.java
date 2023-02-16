package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserRepo;
import com.model.Role;
import com.model.UserInfo;
@Service

public class UserInfoImpl implements UserService{

	@Autowired
	UserRepo repo;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	Roles role;
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

	@Override
	public UserInfo findByUserName(String userName) {
		return repo.findByUserName(userName);
	}

	@Override
	public void registration(UserInfo user) {
		List<Role> ro=new ArrayList<Role>();
		ro.add(role.getByRoleID(1l));
		user.setRoles(ro);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
			repo.save(user);
		}
		
		
		
	

}
