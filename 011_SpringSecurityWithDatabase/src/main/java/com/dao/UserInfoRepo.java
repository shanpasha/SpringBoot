package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.UserInfo;

public interface UserInfoRepo extends JpaRepository<UserInfo, Long> {
	
	public UserInfo findByUserName(String userName);
	

}
