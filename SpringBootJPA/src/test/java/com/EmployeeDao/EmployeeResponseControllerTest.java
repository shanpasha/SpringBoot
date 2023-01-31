package com.EmployeeDao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.RestController.EmployeeResposenseEntityController;
import com.model.Employee;

@SpringBootTest
public class EmployeeResponseControllerTest {
	@Autowired
  EmployeeResposenseEntityController con;

	
	@Test
	public void  saveFindAllDelete() {
		
		Employee employee=new Employee(2, "shannu", 46500,"dev");
		con.save(employee);
		assertThat(employee,hasProperty("id", equalTo(2)));
		assertThat(employee,hasProperty("name", equalTo("shannu")));
		

		List<Employee> emp=(List<Employee>) con.findAll().getBody();
		
		assertThat(emp,hasItem(hasProperty("id",equalTo(2))));
		
		con.deleteById(2);
		
		emp=(List<Employee>) con.findAll().getBody();
		assertThat(emp,hasSize(2));
		
	}
	
	@Test
	public void findByid() {
		
		Employee emp=(Employee) con.findById(0).getBody();
		assertThat(emp, hasProperty("name",equalTo("Srikanth")));
		
	}
	
	@Test
	public void update() {
		Employee employee=new Employee(4, "shanu", 85000, "dev");
		con.update(employee);
		assertThat(employee,hasProperty("name",equalTo("shanu")));
		
		List<Employee>employees=(List<Employee>) con.findAll().getBody();
				
				assertThat(employees,hasItem(hasProperty("id",equalTo(4))));
		
		
		
	}

	
	

}
