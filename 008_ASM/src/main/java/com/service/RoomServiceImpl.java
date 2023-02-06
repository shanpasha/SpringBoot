package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.RoomRepo;
import com.model.Room;
@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomRepo repo;
	
	
	@Override
	public void save(Room room) {
	
		repo.save(room);
	}

	@Override
	public void update(Room room) {
		repo.save(room);
		
	}

	@Override
	public Room getByidRoomId(Long id) {
	
		return repo.findById(id).get();
	}

	@Override
	public List<Room> getAllRooms() {
		
		return repo.findAll();
	}

	@Override
	public void deleteByRoomId(Long id) {
	
		repo.deleteById(id);
	}

}
