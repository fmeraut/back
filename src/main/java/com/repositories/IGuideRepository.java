package com.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Query("select g from Guide g where g.validated=0")
	public List<Guide> findUnvalidated();
	
	@Query("select g from Guide g where g.validated=1")
	public List<Guide> findvalidated();
	
	@Transactional
	@Modifying
	@Query("update Guide set validated=1 where id=:x")
	public void validate(@Param("x") Long id);
	
	@Query("from Guide g order by g.rating desc")
	public List<Guide> findTop();
	
	@Query("from Guide g order by g.country asc")
	public List<Guide> findCountryList();
}
