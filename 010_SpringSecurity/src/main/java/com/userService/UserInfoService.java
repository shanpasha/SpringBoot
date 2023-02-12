package com.userService;

import java.util.List;

import com.model.UserInfo;

public interface UserInfoService {
	
	UserInfo findByid(Long id);
	UserInfo findByUserName(String username);
	void DeleteById(Long id);
	List<UserInfo> findAll();
	void update(UserInfo user);
	void save(UserInfo user);
	

}
