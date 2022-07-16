package com.fin.homeloan.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class LoanDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer loanDetailId; 
	private Long totalLoanRequired; 
	private Integer tenureofLoan; 
	private Float annualInterest;
	private Long payableLoan;

}
