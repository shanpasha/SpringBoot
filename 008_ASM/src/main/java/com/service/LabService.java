package com.service;

import java.util.List;

import com.model.Lab;

public interface LabService {
	
	void save(Lab asset);
	void delete(Integer id);
	void update(Lab lab);
	Lab getByLabID(Integer id);
	List<Lab> getAllLabs();

}
