package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Student {
@Id
private	int id;
private	String name;
private double fee;


	
}
