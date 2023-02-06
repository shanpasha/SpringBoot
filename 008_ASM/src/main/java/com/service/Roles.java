package com.service;

import java.util.List;

import com.model.Role;

public interface Roles {
	
	void save(Role role);
	void delete(Long id);
	void update(Role role);
	Role getByRoleID(Long id);
	List<Role> getAllRoles();

}
