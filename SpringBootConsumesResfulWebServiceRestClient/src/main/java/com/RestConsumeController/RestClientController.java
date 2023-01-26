package com.RestConsumeController;

//

//resefulWeb Service consumed by /SpringBoot this project

//

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
import org.springframework.web.client.RestTemplate;

import com.model.Employee;

@RestController
public class RestClientController {
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/Emp/Service")
	public Employee[] callEmpService(){
		return restTemplate.getForObject("http://localhost:9090/findAll", Employee[].class);
		
		
	}
	//insert method type one
	@PostMapping("/insert/EmpService1")
	public ResponseEntity<?> SendEmp1(@RequestBody Employee employee) {
		
		restTemplate.postForEntity("http://localhost:9090/saveEmp", employee,String.class);
		return new ResponseEntity<>(HttpStatus.OK).ok("Record Saved SucessFully..!");
	}
	
	//insert method type 2
	@PostMapping("/insert/EmpService")
	public Employee SendEmp(@RequestBody Employee employee) {
		
		
		return restTemplate.postForObject("http://localhost:9090/saveEmp", employee,Employee.class);
	}
	
	@PutMapping("/update/EmpService")
	public Employee updateByEmpService(@RequestBody Employee employee) {
		
		restTemplate.put("http://localhost:9090/updateEmp", employee);
		
		return employee;
		
		
		
	}
	
	 @DeleteMapping("/deleteEmp/Service/{id}")
	 public  String deleteEmp(@PathVariable Integer id){
		restTemplate.delete("http://localhost:9090/deleteEmp/{id}", id);
		
		return "Record Deleted Sucessfully...ID:"+id;
   }
	
	 @GetMapping("/getbyId/Service/{id}")
	 public ResponseEntity<Employee> getById(@PathVariable Integer id){
		 
		
		 
		return  restTemplate.getForEntity("http://localhost:9090/getById/{id}",Employee.class,id);
		 
		 
	 }
}
