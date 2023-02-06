package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table
public class Lab {


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		 private Long labId;
		 private String  labName;
		 private String location;
		 private String address;
		 @OneToMany(mappedBy = "lab")
		 private List<Room> rooms;

	
	
}
