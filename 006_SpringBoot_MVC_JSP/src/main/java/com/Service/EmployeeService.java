package com.Service;

import java.util.List;

import com.model.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	void save(Employee employee);
	void update(Employee employee);
	Employee findById(Integer id);
	void deleteById(Integer id);
	

}
