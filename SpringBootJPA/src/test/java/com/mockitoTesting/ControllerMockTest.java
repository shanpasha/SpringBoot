package com.mockitoTesting;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.RestController.EmployeeResposenseEntityController;
import com.Service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Employee;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeResposenseEntityController.class)
public class ControllerMockTest {
	
	
	//refer https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/
	@MockBean
	EmployeeService serv;
	
	@Autowired
	MockMvc mvc;
    
	
	@Test
	public void deleteById() throws Exception {
		
		mvc.perform(delete("/EmpdeleteById/{id}",1)).andExpect(status().isOk());
		
	}
	
	
	@Test
	public void findAll() throws Exception {
		List<Employee> employees=new ArrayList<Employee>();
		employees.add(new Employee(1, "shan", 35000, "dev"));
		employees.add(new Employee(2, "sriman", 30000, "dev"));
		employees.add(new Employee(3, "mahesh", 32000, "dev"));
		employees.add(new Employee(4, "ravi", 25000, "test"));
		
		Mockito.when(serv.findAll()).thenReturn(employees);
		
		mvc.perform(get("/findAllEmp")).andExpect(status().isOk())
		.andExpect(jsonPath("$[0].name", is("shan")));
		
		
		
	}
	@Test
	public void save() throws Exception {
	
		Employee employee =new Employee(22, "shannu", 45600, "Dev");
		
		
		
			  mvc.perform( MockMvcRequestBuilders
				      .post("/saveEmp")
				      .content(asJsonString(new Employee(22, "shannu", 45600, "Dev")))
				      .contentType(MediaType.APPLICATION_JSON)
				      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
			}
			 
			public static String asJsonString(final Object obj) {
			    try {
			        return new ObjectMapper().writeValueAsString(obj);
			    } catch (Exception e) {
			        throw new RuntimeException(e);
			    }
		
			}
}

