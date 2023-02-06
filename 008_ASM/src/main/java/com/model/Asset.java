package com.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Asset {
	

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long assetId;
	    private String rfidTag;
	    private String assetTag;
	    private String serialNumber;
	    private String description;
	    private String friendlyName;
	    private String model;
	    private String manufacturer;
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    @Temporal(TemporalType.DATE)
	    private Date deployDate;
	    private Double cost;
	    private String primaryContact;
	    private String secondryContact;
	    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	    @JoinColumn(name = "roomId")
	    @JsonIgnoreProperties({"assets","lab"})
	    private Room room;

}
