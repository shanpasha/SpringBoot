package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeRepository.EmployeeRepository;
import com.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository repo;

	@Override
	public List<Employee> findAll() {
		
		return repo.findAll();
	}

	@Override
	public void saveOrUpdate(Employee employee) {
		repo.save(employee);
		
	}

	@Override
	public void update(Employee employee) {
		repo.save(employee)	;
	}

	@Override
	public void deleteByID(Integer id) {
	repo.deleteById(id);
		
	}

	@Override
	public Employee findById(Integer id) {
		
		return repo.findById(id).get();
	}
	
	

}
