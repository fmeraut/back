package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.CompanyComments;


@Repository
public interface ICompanyCommentsRepository extends JpaRepository<CompanyComments, Long> {

}
