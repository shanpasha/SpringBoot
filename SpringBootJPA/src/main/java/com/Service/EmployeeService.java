package com.Service;

import java.util.List;

import com.model.Employee;

public interface EmployeeService {
	
List<Employee>findAll();
void saveOrUpdate(Employee employee);
void update(Employee employee);
void deleteByID(Integer id);
Employee findById(Integer id);


}
