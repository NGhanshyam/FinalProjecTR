package com.fin.homeloan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fin.homeloan.app.model.LoanApprovedList;

@Repository
public interface LoanApprovedListRepository extends JpaRepository<LoanApprovedList, Integer> {
	
	public LoanApprovedList findByLoanAid(int id);;
}
