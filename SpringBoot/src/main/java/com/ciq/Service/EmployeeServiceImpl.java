package com.ciq.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciq.DAO.EmployeeDao;
import com.ciq.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	

@Autowired 
EmployeeDao emp;
	@Override
	public List<Employee> getAll() {
		
		return emp.getAll();
	}

	@Override
	public void save(Employee employee) {
		emp.save(employee);
	}

	@Override
	public Employee getById(int id) {
		
		return emp.getById(id);
	}

	@Override
	public void updateByID(Employee employee) {
		emp.updateByID(employee);
	}

	@Override
	public void deleteById(int id) {
	emp.deleteById(id);
		
	}

	

}
