package com.fin.homeloan.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ledger {
	@Id
	private Integer ledgerId;
	private String customerName;
	private String ledgerCreationDate;
	private Double totalLoanAmount;
	private Double payableAmountWithIntrest;
	private Integer tenureInYear;
	private Double monthlyEMI;
	private Double amountPaidTillDate;
	private Double remainingAmount;
	private Integer defaulterCount;
	private String previousEmiStatus;
	private String currentMonthEmiStatus;
	private String loanEndDate;
	private String loanStatus;
}
