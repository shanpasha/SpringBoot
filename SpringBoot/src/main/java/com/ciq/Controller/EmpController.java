package com.ciq.Controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ciq.Service.EmployeeService;
import com.ciq.model.Employee;
import com.ciq.model.ResponseBean;

@RestController
public class EmpController {

	@Autowired
	EmployeeService empService;

	@GetMapping("/hii")
	public String Hello() {
		return "Hello";

	}

	@GetMapping("/findAll")
	public List<Employee> findAll() {
		return empService.getAll();

	}
	//customized ResponseBean
//   @GetMapping("/getById/{id}")
//	public ResponseBean findById(@PathVariable Integer id) {
//	   try {
//		return new ResponseBean(200, empService.getById(id));
//	   }catch (Exception e) {
//		return new ResponseBean(404,"Record Not Found");
//	}
	   
	   
	   @GetMapping("/getById/{id}")
		public ResponseEntity<?> findById(@PathVariable Integer id) {
		   try {
			return new ResponseEntity<Employee>(HttpStatus.OK).ok(empService.getById(id));
		   }catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("Record not Found");
		}
	   
	}

   @DeleteMapping("/deleteById/{id}")
   public String deleteByID(@PathVariable("id") int id) {
	   empService.deleteById(id);
	return "Recorde Deleted Sucessfully..";
	      
   }
   
   
   @PostMapping("/saveEmp")
   public Employee save(@RequestBody Employee employee) {
	   empService.save(employee);
	   return employee;
		   
	   }
   
   @PutMapping("/updateEmp")
 public  Employee updateEmp(@RequestBody Employee employee){
	   
	 empService.updateByID(employee);
	return employee;
	 
   }
	
	 @DeleteMapping("/deleteEmp/{id}")
	 public  String deleteEmp(@PathVariable Integer id){
		 empService.deleteById(id);
		
		return "Record Deleted Sucessfully...";
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
