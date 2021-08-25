package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.entities.CompanyType;

@Repository 
public interface ICompanyTypeRepository extends JpaRepository<CompanyType, Long> {

}
