package com.userService;

import java.util.Collection;

import org.apache.catalina.User;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.UserInfo;
import com.userDetails.UserDetailsImpl;

import lombok.extern.slf4j.Slf4j;
//Step1
@Service
@Slf4j

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserInfoService serv;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserInfo user=serv.findByUserName(username);
		if(user!=null) {
	String pass=user.getPassword();
	log.info("Passsword*****{}",pass);
//	user.setPassword(new BCryptPasswordEncoder().encode(pass));

		log.info("userDetails****{}",user);
		return new UserDetailsImpl(user);}
		else {
			
			
		
	}
		return null;
	}
}
