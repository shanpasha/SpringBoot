//package com.mockitoTesting;
//
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.hasItem;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.hasProperty;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.mockitoSession;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.RestController.EmployeeController;
//import com.Service.EmployeeService;
//import com.model.Employee;
//@WebMvcTest(controllers = EmployeeController.class)
//
//public class ControllerMockTest {
//    
//	@MockBean
//	EmployeeService empl;
//	
//	@Autowired
//	MockMvc mvc;
//	
//	@BeforeEach
//	public void  getAllEmp() {
//		
//		///https://howtodoinjava.com/series/spring-boot-tutorial/ refer for testing
//		
//		when(empl.findById(1)).thenReturn(new Employee(1, "shan", 35000, "dev"));
//		when(empl.findById(2)).thenReturn(new Employee(2, "sriman", 30000, "dev"));
//		when(empl.findById(3)).thenReturn(new Employee(3, "mahesh", 32000, "dev"));
//		when(empl.findById(4)).thenReturn(new Employee(4, "ravi",25000, "test"));
//	
//		when(empl.findAll()).thenReturn(getEmpList());
//		
//	}	
//	
//	public List<Employee> getEmpList() {
//		List<Employee> employees=new ArrayList<Employee>();
//		employees.add(new Employee(1, "shan", 35000, "dev"));
//		employees.add(new Employee(2, "sriman", 30000, "dev"));
//		employees.add(new Employee(3, "mahesh", 32000, "dev"));
//		employees.add(new Employee(4, "ravi", 25000, "test"));
//		return employees;
//	
//		
//	}
//	
//	
//	@Test
//	public void saveAndGetAll() {
//		
//		Employee employee=new Employee();
//		employee.setId(5);
//		employee.setName("suresh");
//		employee.setSalary(26000);
//		employee.setDepartment("test");
//		
//		assertThat(employee,hasProperty("name", equalTo("suresh")));
//
//		
//		//List<Employee> employees=econ.findAll();
//		assertThat(employees, hasItem(hasProperty("name",equalTo("shan"))));
//		
//		
//	}
//	@Test
//	public void delete() {
//	
//		econ.deleteById(1);
//		verify(empl).deleteByID(1);
//		
//	}
//	
//	@Test
//	public void  FindById() {
//	
//		assertEquals("shan", econ.findById(1).getName());
//		
//		
//	}
//	@Test
//	public void Update() {
//		Employee emp=new  Employee(1, "shannu", 45000, "dev");
//		 econ.update(emp);
//		 
//		 verify(empl).update(emp);
//		
//		
//	}
//}
