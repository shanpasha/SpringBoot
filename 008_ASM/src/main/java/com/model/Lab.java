package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
		@NotEmpty(message = "Lab Name required")
		 private String  labName;
		
		@NotEmpty(message = "Location  required")
		 private String location;
		
		@NotEmpty(message = "Address required")
		@Size(message = "Address length between 3 to 20..!",min =3,max = 20)
		 private String address;
		
		 @OneToMany(mappedBy = "lab")
		@JsonIgnoreProperties("lab")
		 private List<Room> rooms;
	
	
}
