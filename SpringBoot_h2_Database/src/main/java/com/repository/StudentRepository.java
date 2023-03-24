package com.repository;

import java.util.List;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
	

	List<Student> findByIdOrName(Integer id,String name);
	
	
	@Query(nativeQuery = true ,value="select * from Student where fee>?1")
	List<Student> greterThanFee(double fee);
	
	
	@Query(nativeQuery = true,value = "select*from Student  where name like= %?1" )
	List<Student> ByFirstLatter(String firstLatter);
	
	List<Student> findByNameLike(String name);
	
	
}
