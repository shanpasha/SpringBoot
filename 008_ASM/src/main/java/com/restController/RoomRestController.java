package com.restController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Lab;
import com.model.Room;
import com.service.LabService;
import com.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomRestController {

	
	@Autowired
	RoomService roomServ;
	
	@Autowired
	LabService Lserv;

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Room room) {
		//one way
//	Lab r=room.getLab();
//	Lab l2=Lserv.getByLabID(r.getLabId());
		
		//second way
		Lab l2=Lserv.getByLabID(room.getLab().getLabId());
		
	room.setLab(l2);
		roomServ.save(room);
		return new ResponseEntity<>(HttpStatus.OK).ok(room);
	}

	@PutMapping("/update")
	public ResponseEntity<?> Update(@RequestBody Room room) {

		try {
			Room r = roomServ.getByidRoomId(room.getRoomId());
			if (r != null) {
				roomServ.save(room);
				return new ResponseEntity<>(HttpStatus.OK).ok(room);
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("Records Not found in this ID: " + room.getRoomId());
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		roomServ.deleteByRoomId(id);
		return new ResponseEntity<>(HttpStatus.OK).ok("ID: " + id + " Deleted Succefully..!");
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(HttpStatus.OK).ok(roomServ.getByidRoomId(id));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("Records Not found in this ID: " + id);
		}

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Room>> getAllRole() {
		return new ResponseEntity<>(HttpStatus.OK).ok(roomServ.getAllRooms());

	}

	
	
	
		
	
}
