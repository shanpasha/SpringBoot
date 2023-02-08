package com.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Role;
import com.service.Roles;

@RequestMapping("/role")
@RestController
public class RoleRestController {
	@Autowired
	Roles roleServ;

	@PostMapping("/save")
	public ResponseEntity<?> saveRole(@RequestBody Role role) {

		roleServ.save(role);
		return new ResponseEntity<>(HttpStatus.OK).ok(role);
	}

	@PutMapping("/update")
	public ResponseEntity<?> UpdateRole(@RequestBody Role role) {

		try {
			Role r=roleServ.getByRoleID(role.getRoleId());
			if(r!=null) {
			roleServ.save(role);
			return new ResponseEntity<>(HttpStatus.OK).ok(role);
			}else {
				throw new Exception();
			}
			
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("Records Not found in this ID: " + role.getRoleId());
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteRole(@PathVariable Long id) {

		roleServ.delete(id);
		return new ResponseEntity<>(HttpStatus.OK).ok("ID: " + id + " Deleted Succefully..!");
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getByRole(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(HttpStatus.OK).ok(roleServ.getByRoleID(id));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("Records Not found in this ID: " + id);
		}

	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Role>>getAllRole(){
		return new ResponseEntity<>(HttpStatus.OK).ok(roleServ.getAllRoles());
		
		
	}
}
