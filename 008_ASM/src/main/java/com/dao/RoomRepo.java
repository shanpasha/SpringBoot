package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Room;

public interface RoomRepo extends JpaRepository<Room, Long>{

}
