package com.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entities.Guide;

@Repository
public interface IGuideRepository extends JpaRepository<Guide, Long>{
	/**
	 * recherche des guides par pays
	 * @param country
	 * @return
	 */
	@Query("from Guide g where g.country like %:x%")
	public List<Guide> findGuideByCountry(@Param("x") String country);
	
	/**
	 * recherche des guides par titre
	 * @param title
	 * @return
	 */
	@Query("from Guide g where g.title like %:x%")
	public List<Guide> findGuideByTitle(@Param("x") String title);
}
