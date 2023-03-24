package com.MockcontrollerTest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.Service.StudentService;
import com.controller.StudentController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Student;

@ExtendWith(SpringExtension.class)

@WebMvcTest(StudentController.class )

public class StudentControllerTest {
	


	@MockBean
	 StudentService serv;
	@Autowired
	 MockMvc mvc;
	
	@Test
	public void findAll() throws Exception {
		Student st =new Student(1, "shan", 4500);
		Student st1 =new Student(2, "sri", 5500);
		Student st2 =new Student(3, "ravi", 6500);
		List<Student> students=Arrays.asList(new Student[] {st,st1,st2});
		
		Mockito.when(serv.findByAll()).thenReturn(students);
	serv.findByAll();
		mvc.perform(get("/getAll"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", Matchers.hasSize(3)))
        .andExpect(jsonPath("$[0].name", Matchers.is("shan"))).
        andExpect(jsonPath("[1].name", Matchers.is("sri")));
			
		//$ return All json data
		//$[0] return index 0 json data
		//$[1] return index 2 json data

	}
	
	
	
	@Test
	public void save() throws Exception {
		Student stu=new Student(55, "shan", 48000);
		
		mvc.perform(post("/save").content(jsonData(new Student(55, "shan", 48000)))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		 .andExpect(jsonPath("$.name").value("shan"));
		
	}
	
	
	public  String jsonData( Object obj) {
		
		try {
			return  new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
		
		throw new RuntimeException();
		}
		
		
		
		
		
	}

	@Test
	public void findByid() throws Exception {
		
		Student e=new Student(1, "shannu", 48000);
		
		Mockito.when(serv.findById(1)).thenReturn(e);
		
		mvc.perform(get("/getById/"+e.getId())).andExpect(status().isOk())
		.andExpect(jsonPath("$.name", Matchers.is("shannu")))
		.andExpect(jsonPath("$.id", is(1)));
		
		
		
	}
	
	@Test
	public void deleteById() throws Exception{
		
		Student em=new Student(1, "shannu", 78000);
		serv.deleteById(1);
		
		mvc.perform(delete("/deleteById/"+em.getId())).andExpect(status().isOk());
		
	}
	
	
	@Test
	public void UpdateStu() throws Exception {
		
		mvc.perform(put("/update")
				.content(jsonData(new Student(4, "immu", 85000)))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name", is("immu")))
		.andExpect(jsonPath("$.id=", is(4)));

		

		
		
	}
	
	
}
