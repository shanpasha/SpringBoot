package com.Service;

import java.util.List;

import com.model.Student;

public interface StudentService {
	
	List<Student>findByAll();
	 Student findById(Integer id);
	 void deleteById(Integer id);
	 Student save (Student student);
	 void update(Student student);
	 
	 List<Student> findByIdOrName(Integer id,String name);
	 
	 
	 
	 List<Student> greterThanFee(double fee);
	

}
