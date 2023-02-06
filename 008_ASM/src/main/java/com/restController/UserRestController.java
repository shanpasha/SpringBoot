package com.restController;

import java.util.ArrayList;
import java.util.List;import javax.validation.ReportAsSingleViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Role;
import com.model.UserInfo;
import com.service.Roles;
import com.service.UserService;


@RestController
public class UserRestController {
	@Autowired
	UserService serv;
	@Autowired
	Roles rserv;
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody UserInfo user){
		List<Role> roles=new ArrayList<Role>();
		for (Role role : user.getRoles()) {
			roles.add(rserv.getByRoleID(role.getRoleId()));
	
			System.out.println(roles.add(rserv.getByRoleID(role.getRoleId())));
		}
		user.setRoles(roles);
		serv.addUser(user);
		return (ResponseEntity<?>) new ResponseEntity<>(HttpStatus.OK).ok(user);
		
	}
	
	
	@GetMapping("/getUsers")
	public ResponseEntity<?> getUsers(){
		return new ResponseEntity<>(HttpStatus.OK).ok(serv.getAllUsers());
		
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@RequestBody() @PathVariable Long id){
		serv.deleteUserRole(id);
    // serv.deleteUser(id);
		
		//return new ResponseEntity<>(HttpStatus.OK).ok(id+"Deleted Succefully");
		
		
		
	}

}
