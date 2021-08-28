package com.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entities.PlaceComment;

@Repository
public interface IPlaceCommentRepository extends JpaRepository<PlaceComment, Long>{
	/**
	 * trouver les commentaires par lieu
	 * @param id
	 * @return
	 */
	@Query("from PlaceComment pc inner join pc.place p where p.id= :x")
	public List<PlaceComment> findByPlace(@Param("x") Long id);
}
