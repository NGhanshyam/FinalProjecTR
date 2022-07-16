package com.fin.homeloan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fin.homeloan.app.model.Applicant;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {

}
