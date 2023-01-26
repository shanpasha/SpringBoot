package com.ciq.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ciq.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	JdbcTemplate jdbctemplate;

	@Override
	public List<Employee> getAll() {

		return jdbctemplate.query("Select*from Employee", new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	@Override
	public void save(Employee employee) {

		jdbctemplate.update("insert into employee values(?,?,?,?)", employee.getId(), employee.getName(),
				employee.getSalary(), employee.getEmail());

	}

	@Override
	public Employee getById(int id) {

		return jdbctemplate.queryForObject("select*from Employee Where id=?",
				new BeanPropertyRowMapper<>(Employee.class), id);
	}

	@Override
	public void updateByID(Employee employee) {
		jdbctemplate.update("update employee set name=?,salary=?,email=? where id=?",
				employee.getName(),employee.getSalary(),employee.getEmail(),employee.getId());
		
	}

	@Override
	public void deleteById(int id) {
		jdbctemplate.update("delete from employee where id=?", id);

	}

}
