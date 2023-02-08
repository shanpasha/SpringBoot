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
import com.service.LabService;

@RestController
@RequestMapping("/lab")
public class LabRestController {
	@Autowired
	LabService labServ;

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Lab lab) {

		labServ.save(lab);
		return new ResponseEntity<>(HttpStatus.OK).ok(lab);
	}

	@PutMapping("/update")
	public ResponseEntity<?> Update(@RequestBody Lab lab) {

		try {
			Lab r = labServ.getByLabID(lab.getLabId());
			if (r != null) {
				labServ.save(lab);
				return new ResponseEntity<>(HttpStatus.OK).ok(lab);
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("Records Not found in this ID: " + lab.getLabId());
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		try {
			Lab l = labServ.getByLabID(id);
			if (l != null) {
				labServ.delete(id);
				return new ResponseEntity<>(HttpStatus.OK).ok("ID: " + id + " Deleted Succefully..!");

			} else {
				throw new Exception();

			}

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.OK).ok("Record Not Found In This ID: " + id  );

		}
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(HttpStatus.OK).ok(labServ.getByLabID(id));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND).ok("Records Not found in this ID: " + id);
		}

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Lab>> getAllRole() {
		return new ResponseEntity<>(HttpStatus.OK).ok(labServ.getAllLabs());

	}

}
