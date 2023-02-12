package com.userService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.UserRepo.UserRepo;
import com.model.UserInfo;
@Service

public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	UserRepo repo;

	@Override
	public UserInfo findByid(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public UserInfo findByUserName(String username) {
		
		return repo.findByUserName(username);
	}

	@Override
	public void DeleteById(Long id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<UserInfo> findAll() {
		return repo.findAll();
	}

	@Override
	public void update(UserInfo user) {
    repo.save(user);		
	}

	@Override
	public void save(UserInfo user) {
		repo.save(user);
		
	}
	

}
