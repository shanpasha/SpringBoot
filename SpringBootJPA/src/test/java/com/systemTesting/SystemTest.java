package com.systemTesting;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;

import java.util.Arrays;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.model.Employee;

public class SystemTest {
	RestTemplate r=new RestTemplate();
	@Test
	@Disabled
	public void applicationTest() {
		
		
		
		
		String saveUrl="http://localhost:9090/saveEmp";
		String deleteUrl="http://localhost:9090/EmpdeleteById/{id}";
		
		
				
		Employee em=new Employee(18, "shannnnuuu", 36200, "dev");
		
	ResponseEntity<Employee> empl=	r.postForEntity(saveUrl, em, Employee.class);
	assertThat(empl,hasProperty("id",equalTo(18)));
	
	}
	
	
	@Test
	public void findAllApllicationTest() {
		
		String readUrl="http://localhost:9090/findAllEmp";
	Employee[] employees=	r.getForEntity(readUrl, Employee[].class).getBody();

	assertThat(Arrays.asList(employees),hasItem(hasProperty("id",equalTo(0))));
	}


@Test
public void findById() {
	
	String readByIdUrl="http://localhost:9090/EmpfindById/";
	Employee em=r.getForEntity(readByIdUrl+0,Employee.class).getBody();
	
	assertThat(em, hasProperty("id",equalTo(0)));
	assertThat(em, hasProperty("name",equalTo("Srikanth")));
	
}
@Test
public void delete() {
	String deleteUrl="http://localhost:9090/EmpdeleteById/";
	
	r.delete(deleteUrl+18);
	

	
	
}

}










