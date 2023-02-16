package com.Service;

import com.model.UserInfo;

public interface UserInfoService {
	public UserInfo findByUserName(String userName);
	
	void save(UserInfo user);
}
