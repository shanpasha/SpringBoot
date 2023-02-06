package com.service;

import java.util.List;

import com.model.Role;

public interface Roles {
	
	void save(Role role);
	void delete(Integer id);
	void update(Role role);
	Role getByRoleID(Integer id);
	List<Role> getAllRoles();

}
