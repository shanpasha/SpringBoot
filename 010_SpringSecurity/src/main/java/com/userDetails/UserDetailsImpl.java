package com.userDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import com.model.UserInfo;

import lombok.extern.slf4j.Slf4j;
//Step2
@Slf4j
@Transactional
public class UserDetailsImpl implements UserDetails {

	UserInfo userInfo;
	 

	public UserDetailsImpl(UserInfo userInfo) {
		super();
		this.userInfo = userInfo;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		System.out.println(authorities);
		userInfo.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
		
		log.info("Roles:*****{}",authorities);
		return  authorities;
	}

	@Override
	public String getPassword() {
		return userInfo.getPassword();
	}

	@Override
	public String getUsername() {
		
		return userInfo.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return userInfo.getIsActive();
	}

	
}
