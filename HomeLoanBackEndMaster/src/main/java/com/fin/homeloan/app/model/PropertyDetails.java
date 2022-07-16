package com.fin.homeloan.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer propertyId; 
	private String propertyType; 
	private String propertyPrice; 
	private String propertyLocation;
}
