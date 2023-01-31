package com.EmployeeDao;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.RestController.EmployeeController;
import com.model.Employee;

@SpringBootTest
public class EmployeeServiceTest {
	@Autowired
	EmployeeController employeeController;
	
	
	@Test
	public void findAllTest() {
		List<Employee> emps=employeeController.findAll();
	assertThat(emps,not(empty()));
		
	}
	
	
	@Test
	@Disabled
	public void Save() {
		Employee emp=new Employee();
		emp.setDepartment("java developer");
		emp.setName("kumar");
		emp.setSalary(78900);
    Employee emp2=	employeeController.save(emp);
	
	assertThat(emp2, hasProperty("name",equalTo("kumarr")));
		
		
	}
	
	
	@Test
	public void update() {
		Employee emp=new Employee();
		emp.setId(4);
		emp.setDepartment("Testing");
		emp.setName("kumar");
		emp.setSalary(78900);
    Employee emp2=	employeeController.save(emp);
	
	assertThat(emp2, hasProperty("department",equalTo("Testing")));
		
		
	}
	
	
	@Test
	public void findById() {
		
	Employee employee =employeeController.findById(4);	
		assertThat(employee, hasProperty("id",equalTo(4)));
		assertThat(employee, hasProperty("name",equalTo("kumar")));
	}
	
	
	@Test
	public void saveFindDelete() {
		
		Employee emp=new Employee();
		emp.setDepartment("developer");
		emp.setName("Srikanth");
		emp.setSalary(36000);
		emp.setId(1);
		
		Employee employye=employeeController.save(emp);
		
		
		assertThat(employye,hasProperty("name",equalTo("Srikanth")));
		
		List<Employee> empl=employeeController.findAll();
		
		assertThat(empl,hasItem(hasProperty("name",equalTo("Srikanth"))));
		
		employeeController.deleteById(1);
		
		 empl=employeeController.findAll();
	
		 assertThat(empl,hasSize(2));
		
		
		
		
	}
	
}
