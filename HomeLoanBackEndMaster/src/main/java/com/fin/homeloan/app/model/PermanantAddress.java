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
public class PermanantAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paId; 
	private String areaName; 
	private String cityName; 
	private String stateName; 
	private Long pincodeNo;
}
