package com.ciq.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.ciq.Service.EmployeeService;
import com.ciq.model.Employee;

//

//RestFulWebService provides to /SpringBootConsumesResfulWebServiceRestClient this project

//
@RestController
public class EmpRESTControllerWithSpringResponseEntity {
public static Logger log=LoggerFactory.getLogger(EmpRESTControllerWithSpringResponseEntity.class);

	@Autowired
	EmployeeService empService;

	@GetMapping("/RfindAll")
	public ResponseEntity<?> findAll() {
		try {
			return new ResponseEntity<>(HttpStatus.OK).ok(empService.getAll());
		} catch (Exception e) {
			return new ResponseEntity<>("No recordsFound..", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/RgetById/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(HttpStatus.OK).ok(empService.getById(id));
		} catch (Exception e) {
			return new ResponseEntity<>("No records Found by This Id: " + id, HttpStatus.NOT_FOUND);

		}
	}

	
	
	@DeleteMapping("/RdeleteById/{id}")
	public ResponseEntity<?> deleteByID( @PathVariable("id") int id)  {
		
		
		
		
		empService.deleteById(id);
	
			//return new ResponseEntity<>("Record Deleted SucessFully..!",HttpStatus.OK);
	
		
		return new  ResponseEntity<>("Record not Found in this ID: "+id,HttpStatus.NOT_FOUND);
		
		
	}

	@PostMapping("/RsaveEmp")
	public ResponseEntity<?> save( @RequestBody Employee employee) {
		try{
			return new ResponseEntity<>("Record Saved Sucessfully..!", HttpStatus.OK);
		}catch (Exception e) {
		
			return new ResponseEntity<>("Inserting Failed Try Again" , HttpStatus.NOT_FOUND);
		}
	}

	
	
	   @PutMapping("/RupdateEmp")
	   public   ResponseEntity<?> updateEmp(@RequestBody Employee employee){
		   empService.updateByID(employee);
	  return new ResponseEntity(HttpStatus.OK).ok("ok");	
	  	
}
}
