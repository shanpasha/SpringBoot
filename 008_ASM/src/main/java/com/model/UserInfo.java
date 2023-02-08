package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.JoinColumn;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table
@AllArgsConstructor
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Column(unique = true)
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String email;
	private String mobile;
	private String department;
	private Boolean isActive;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "user_role",joinColumns = { @JoinColumn(name ="userId") },
	inverseJoinColumns = {@JoinColumn(name = "roleId")})
	@JsonIgnoreProperties("users")
	private List<Role> roles;
	

	


}
