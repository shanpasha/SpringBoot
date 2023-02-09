package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@Entity
@Data
@Table

public class Role {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long roleId;
		@NotEmpty(message = "Role name required...! ")
		private String roleName;
		
		@ManyToMany(mappedBy = "roles")
	@JsonIgnoreProperties("roles")
		@ToString.Exclude
	private List<UserInfo> users;

	


}
