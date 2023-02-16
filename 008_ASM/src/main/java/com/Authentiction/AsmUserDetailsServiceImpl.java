package com.Authentiction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.model.UserInfo;
import com.service.UserService;
@Service

public class AsmUserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserService serv;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	UserInfo user=serv.findByUserName(username);
	if(user!=null) {
		return new AsmUserDetails(user);
	}else {
		
		return null;
	
	}
	}
	

}
