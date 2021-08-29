package com.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entities.Place;
import com.entities.Place;

@Repository
public interface IPlaceRepository extends JpaRepository<Place, Long>{
	/**
	 * recherche des lieux par pays
	 * @param country
	 * @return
	 */
	@Query("from Place p where p.country like %:x%")
	public List<Place> findPlaceByCountry(@Param("x") String country);
	
	/**
	 * recherche des lieux par titre
	 * @param title
	 * @return
	 */
	@Query("from Place p where p.title like %:x%")
	public List<Place> findPlaceByTitle(@Param("x") String title);
	
	/**
	 * trouver les lieux par guide
	 * @param id
	 * @return
	 */
	@Query("from Place p inner join p.guides g where g.id= :x")
	public List<Place> findByGuide(@Param("x") Long id);
	
	@Query("from Place e order by e.rating desc")
	public List<Place> findTop();
	
	@Query("from Place e order by e.country asc")
	public List<Place> findCountryList();

}
