package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Company;

@Repository
public interface ICompanyRepository extends JpaRepository<Company, Long> {
	

}
