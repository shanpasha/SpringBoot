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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Asset {
	

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	
		private Long assetId;
		@NotEmpty(message = "required Rfid")
	    private String rfidTag;
		
		@NotEmpty(message = "required Asset Tag")
	    private String assetTag;
		
		@NotEmpty(message = "required Serial Number")
	    private String serialNumber;
		
		@NotEmpty(message = "required Description")
	    private String description;
		
		@NotEmpty(message = "required Friendly Name")
	    private String friendlyName;
		
		@NotEmpty(message = "required Model")
	    private String model;
		
		@NotEmpty(message = "required Manufacturer")
	    private String manufacturer;
		
		
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    @Temporal(TemporalType.DATE)
	    private Date deployDate;
	    
	    @NotNull(message = "Please enter a valid salary")
	    @Min(value=1000, message = "cost must be atleast 1000.00")
	    @Max(value=40000, message = "cost should not be greater than 40000.00")
	    private Double cost;
	    
	    @NotEmpty(message = "Primary Contact")
	    private String primaryContact;
	    
	    @NotEmpty(message = "required Secondry Contact")
	    private String secondryContact;
	
	    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	    @JoinColumn(name = "roomId")
	     @JsonIgnoreProperties("assets")
	   	    private Room room;

}
