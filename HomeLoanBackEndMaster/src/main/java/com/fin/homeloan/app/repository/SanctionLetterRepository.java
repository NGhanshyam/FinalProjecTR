package com.fin.homeloan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fin.homeloan.app.model.SanctionLetter;

@Repository
public interface SanctionLetterRepository extends JpaRepository<SanctionLetter, Integer>{

	
	 SanctionLetter findBySanctionId(int id);
}
