package com.restController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Asset;
import com.model.Room;
import com.service.AssetService;
import com.service.RoomService;

@RestController
@RequestMapping("/Asset")
public class AssetRestController {
	@Autowired
	AssetService serv;
	@Autowired
	RoomService Rserv;

	@PostMapping("/update")
	public ResponseEntity<?> Update(@Valid @RequestBody Asset asset) {
		try {
			Asset a = serv.getByAssetID(asset.getAssetId());

			if (a != null) {
				serv.save(asset);
			} else {
				throw new Exception();
			}
			return new ResponseEntity<>(HttpStatus.OK).ok(asset);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("Record Not found in this ID: " + asset.getAssetId());
		}
	}

	@PostMapping("/saveAsset")
	public ResponseEntity<?> save(@Valid @RequestBody Asset asset) {
//		first way
//		Room rm=asset.getRoom();
//		Room rm2=Rserv.getByidRoomId(rm.getRoomId());
		//second way
		Room rm2= Rserv.getByidRoomId(asset.getRoom().getRoomId());		
		asset.setRoom(rm2);
		serv.save(asset);
		return new ResponseEntity<>(HttpStatus.OK).ok(asset);
	}

	@GetMapping("/getAssets")
	public ResponseEntity<?> getAssets() {
		return new ResponseEntity<>(HttpStatus.OK).ok(serv.getAllAssets());

	}

	@DeleteMapping("/deleteAsset")
	public ResponseEntity<?> deleteAsset(Long id) {
		serv.delete(id);
		return new ResponseEntity<>(HttpStatus.OK).ok("deleted succefully id No :" + id);

	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(HttpStatus.OK).ok(serv.getByAssetID(id));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("Records not found in this ID :" + id);
		}

	}

}
