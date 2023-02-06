package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LabRepo;
import com.model.Lab;
@Service
public class LabServiceImpl implements LabService {

	@Autowired
	LabRepo repo;
	
	@Override
	public void save(Lab asset) {
		repo.save(asset);
		
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

	@Override
	public void update(Lab lab) {
		repo.save(lab);
	}

	@Override
	public Lab getByLabID(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Lab> getAllLabs() {
		return repo.findAll();
	}

}
