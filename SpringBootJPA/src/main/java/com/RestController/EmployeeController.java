package com.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.Service.EmployeeServiceImpl;
import com.model.Employee;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl employeeService;

	@GetMapping("/findAll")
	public List<Employee> findAll() {

		return employeeService.findAll();

	}
	
	
	@PostMapping("/save")
	public Employee save(Employee employee) {
		employeeService.saveOrUpdate(employee);
		
		return employee;
		
		
	}
	
	@PutMapping("/update")
	public Employee update (Employee employee) {
		employeeService.update(employee);
		
		return employee;
	
	}
	
	@GetMapping("/findById/{id}")
	public Employee findById(@PathVariable Integer id) {
		return employeeService.findById(id);
		
		
	}
	
	@GetMapping("/deleteById/{id}")
	public String deleteById(@PathVariable Integer id) {
		employeeService.deleteByID(id);
		return "Deleted Sucessfully ID "+id;
		
		
	}
	
	
	
	
	
	

}
