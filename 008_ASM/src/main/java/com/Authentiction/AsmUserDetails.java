package com.Authentiction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.model.UserInfo;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class AsmUserDetails implements UserDetails {
	
	UserInfo user;
	

	public AsmUserDetails(UserInfo user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		
		user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
		
		log.info("Role*****{}",authorities);
		return authorities;
	}

	@Override
	public String getPassword() {
	
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserName();
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
		return true;
	}

	

}
