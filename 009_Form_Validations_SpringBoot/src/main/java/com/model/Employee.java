package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "Employee_file")
public class Employee  {
	
	@Id

private 	Integer id;
	@Size(message = "Name length Should be greater than 3",min= 3)
private	String name;

@NotNull(message = "Enter salary")
@Min(message = "salary should greater than 10000",value = 10000)

private	Double salary;
@NotEmpty(message = "please Enter Email Id")
	String email;
	




}
