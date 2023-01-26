package com.ciq.Service;

import java.util.List;

import com.ciq.model.Employee;

public interface EmployeeService {
	
	public List<Employee>getAll();
	public void save(Employee employee);
	public Employee getById(int id);
	public void updateByID(Employee employee);
	public void deleteById(int id);
	
	

}
