package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Service.StudentService;
import com.model.Student;

@RestController
public class StudentController {
	
	@Autowired 
	StudentService serv;
	
	@PostMapping("/save")
	public ResponseEntity<?>save(@RequestBody Student student){
		serv.save(student);
		try {
			return new ResponseEntity <>(HttpStatus.OK).ok(student) ;
		} catch (Exception e) {
			return new ResponseEntity <>(HttpStatus.NOT_FOUND).ok("Enter valid Details") ;
		}
	}
	
	@GetMapping({"/getAll",})
	public ResponseEntity<?> findAll(){
		
		try {
			return new ResponseEntity<>(HttpStatus.OK).ok(serv.findByAll());
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("Records not Found");		}
	}

	
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> findbyId(@PathVariable Integer id){
		
		try {
			return new ResponseEntity<>(HttpStatus.OK).ok(serv.findById(id));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("Records not Found");		}
	}
	
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id){
		
		try {
			serv.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK).ok("deleted Sucessfully");
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("Records not Found");		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Student student){
		
		try {
			serv.update(student);
			return new ResponseEntity<>(HttpStatus.OK).ok(student);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("Records not Found");		}
	}
	
	
	@GetMapping("/getByIdOrName/{id}/{name}")
	public ResponseEntity<?> getByIdOrName(@PathVariable("id") Integer id ,@PathVariable("name")String name){
		
		try {
			
			return new ResponseEntity<>(HttpStatus.OK).ok(serv.findByIdOrName(id, name));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("Records not Found");		}
	}
	
	@GetMapping("/greterFee/{fee}")
	public ResponseEntity<?>greterThanFee(@PathVariable double fee){
		try {
		return new ResponseEntity<>(HttpStatus.OK).ok(serv.greterThanFee(fee));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.OK).ok("no record found");
		}
		
		
	}
	
}
