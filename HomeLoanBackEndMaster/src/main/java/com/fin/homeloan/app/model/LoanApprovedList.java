package com.fin.homeloan.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanApprovedList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer loanAid;
	@OneToOne(cascade = CascadeType.ALL)
	private Applicant applicant; 
	@OneToOne(cascade = CascadeType.ALL)
	private LoanDetails loanDetails; 
	@OneToOne(cascade = CascadeType.ALL)
	private Sanction sanction;

}
