package com.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Service.EmployeeServiceImpl;
import com.model.Employee;

@RestController
public class EmployeeResposenseEntityController {
	
	@Autowired
	EmployeeServiceImpl employeeService;
	
	
	@GetMapping("/findAllEmp")
	public ResponseEntity<?> findAll() {

		try {
		return new ResponseEntity<>(HttpStatus.OK).ok(employeeService.findAll());
		
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("No records Found");
		}
	}
	
	
	@PostMapping("/saveEmp")
	public ResponseEntity<?> save(@RequestBody Employee employee) {
		try {
			employeeService.saveOrUpdate(employee);
			return new ResponseEntity<>(HttpStatus.OK).ok(employee+" Record Saved sucessfully");
			}catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("enter valid details");
			}
		}
	
	@PutMapping("/empupdate")
	public ResponseEntity<?> update (@RequestBody Employee employee) {
		employeeService.update(employee);
		try {
			employeeService.update(employee);
			return new ResponseEntity<>(HttpStatus.OK).ok(employee);
			}catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("enter valid details");
			}
		}
	
	@GetMapping("/EmpfindById/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		try {
			
			return new ResponseEntity<>(HttpStatus.OK).ok(employeeService.findById(id));
			}catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("record Not found in this ID "+id);
			}
		}
	@GetMapping("/EmpdeleteById/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {
try {
			employeeService.deleteByID(id);
			return new ResponseEntity<>(HttpStatus.OK).ok(  id+" Record deleted sucessfully ");
			}catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("record Not found in this ID "+id);
			}
		}
		
	}
	


