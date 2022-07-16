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
public class Applicant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer applicationId; 
	private String profession; 
	private String dob;
	private Integer age; 
	private long annualincome;
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer; 
	@OneToOne(cascade = CascadeType.ALL)
	private PermanantAddress paddr; 
	@OneToOne(cascade = CascadeType.ALL)
	private LoanDetails loanDetails;
	@OneToOne(cascade = CascadeType.ALL)
	private PropertyDetails propertydetails; 
	@OneToOne(cascade = CascadeType.ALL)
	private ConstumerBankDetails bankDetails;


}
