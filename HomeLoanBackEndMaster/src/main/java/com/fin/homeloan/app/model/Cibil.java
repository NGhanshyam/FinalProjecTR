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
@NoArgsConstructor
@AllArgsConstructor
public class Cibil {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cibilId;
	private Integer cibilScore;
	private String cibilStatus;
	private String cibilRemark;
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
}
