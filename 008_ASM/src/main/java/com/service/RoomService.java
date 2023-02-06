package com.service;

import java.util.List;

import com.model.Room;

public interface RoomService {
	
	void save (Room room);
	void update (Room room);
	Room getByidRoomId(Long id);
	List<Room>getAllRooms();
	void deleteByRoomId(Long id);

}
