package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserInfoRepo;
import com.model.UserInfo;

@Service

public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	UserInfoRepo repo;

	@Override
	public UserInfo findByUserName(String userName) {
		
		return repo.findByUserName(userName) ;
	}

	

}
