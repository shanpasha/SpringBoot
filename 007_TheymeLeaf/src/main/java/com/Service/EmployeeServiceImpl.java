package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.EmployeeRepo;
import com.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepo repo;
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void save(Employee employee) {
		repo.save(employee);
		
	}

	@Override
	public void update(Employee employee) {
		repo.save(employee);
		
	}

	@Override
	public Employee findById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
		
	}

}
