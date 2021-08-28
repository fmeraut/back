package com.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entities.ExpComment;

@Repository
public interface IExpCommentRepository extends JpaRepository<ExpComment, Long>{
	/**
	 * trouver les commentaires par experience
	 * @param id
	 * @return
	 */
	@Query("from ExpComment c inner join c.experience e where e.id= :x")
	public List<ExpComment> findByExperience(@Param("x") Long id);

}
