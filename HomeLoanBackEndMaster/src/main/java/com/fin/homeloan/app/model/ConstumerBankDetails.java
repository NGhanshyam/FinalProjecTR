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
public class ConstumerBankDetails {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer bankId; 
private Long accountNo; 
private String ifscCode; 
private String bankName;
private String branchAddress;
}
