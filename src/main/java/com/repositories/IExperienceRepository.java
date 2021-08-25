package com.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entities.Experience;
import com.entities.Guide;

@Repository
public interface IExperienceRepository extends JpaRepository<Experience, Long>{

	/**
	 * 
	 * @param country
	 * @return
	 */
	@Query("from Experience e where e.country like %:x%")
	public List<Experience> findByCountry(@Param("x") String country);

	/**
	 * 
	 * @param title
	 * @return
	 */
	@Query("from Experience e where e.title like %:x%")
	public List<Experience> findByTitle(@Param("x") String title);
	
	@Query("select e from Experience e where e.validated=0")
	public List<Experience> findUnvalidated();
	
	@Transactional
	@Modifying
	@Query("update Experience set validated=1 where id=:x")
	public void validate(@Param("x") Long id);

}
