package com.service;

import java.util.List;

import com.model.Lab;

public interface LabService {
	
	void save(Lab lab);
	void delete(Long id);
	void update(Lab lab);
	Lab getByLabID(Long id);
	List<Lab> getAllLabs();

}
