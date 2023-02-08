package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Lab {


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		 private Long labId;
		 private String  labName;
		 private String location;
		 private String address;
		
		 @OneToMany(mappedBy = "lab")
		@JsonIgnoreProperties("lab")
		 private List<Room> rooms;
	
	
}
