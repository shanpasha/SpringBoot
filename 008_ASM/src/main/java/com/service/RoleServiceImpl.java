package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.RoleRepo;
import com.model.Role;

@Service
public class RoleServiceImpl implements Roles{

	@Autowired 
	RoleRepo repo;
	
	@Override
	public void save(Role role) {
		repo.save(role);
		

	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
		
	}

	@Override
	public void update(Role role) {
		repo.save(role);
		
	}

	@Override
	public Role getByRoleID(Long id) {
	return repo.findById(id).get();
		
	}

	@Override
	public List<Role> getAllRoles() {
		
		return repo.findAll();
	}

}
