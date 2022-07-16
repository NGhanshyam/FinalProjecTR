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
@AllArgsConstructor
@NoArgsConstructor
public class Sanction {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sanctionedId;
	private Long sanctionedAmount;
	private Integer loanRefundTenure;
	final Float rateofInterest=14.0f;
}
