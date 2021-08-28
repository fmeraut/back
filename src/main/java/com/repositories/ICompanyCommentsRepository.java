package com.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entities.CompanyComments;


@Repository
public interface ICompanyCommentsRepository extends JpaRepository<CompanyComments, Long> {
	/**
	 * trouver les commentaires par compagnie
	 * @param id
	 * @return
	 */
	@Query("from CompanyComments cc inner join cc.company c where c.id= :x")
	public List<CompanyComments> findByCompany(@Param("x") Long id);
}
