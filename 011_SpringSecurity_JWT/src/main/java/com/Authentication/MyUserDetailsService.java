package com.Authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Service.UserInfoService;
import com.model.UserInfo;

import lombok.extern.slf4j.Slf4j;
@Service
@Transactional
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

	
	@Autowired
	UserInfoService serv;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserInfo user=serv.findByUserName(username);
		log.info("User******{}",user);
		return new MyUserDetails(user);
	}

}
