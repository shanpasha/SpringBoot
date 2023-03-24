package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.model.Student;
import com.repository.StudentRepository;

@Service
public class StudentServiceImpl  implements StudentService{

	@Autowired
	StudentRepository stu;
	
	@Override
	public List<Student> findByAll() {
		
		return stu.findAll();
	}

	@Override
	public Student findById(Integer id) {
	
		return stu.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
	
		stu.deleteById(id);
		
	}

	@Override
	public Student save(Student student) {
	stu.save(student);
		return  student;
	}

	@Override
	public void update(Student student) {
		intitSave();
		stu.save(student);
		
		
	}
	
	Student s=new Student();
	
	public void intitSave() {
		
		stu.save(new Student(3, "ravi", 150000) );
		stu.save(new Student(4, "sriman", 78000) );
		stu.save(new Student(5, "shan", 35000) );
		stu.save(new Student(1, "ramya", 350000) );
	}

	@Override
	public List<Student> findByIdOrName(Integer id, String name) {
		
		return stu.findByIdOrName(id, name);
	}

	@Override
	public List<Student> greterThanFee(double fee) {
		intitSave();
		return stu.greterThanFee(fee);
	}

}
