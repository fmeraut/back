package com.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entities.GuideComment;

@Repository
public interface IGuideCommentRepository extends JpaRepository<GuideComment, Long> {
	
	@Query("from GuideComment c inner join c.guide e where e.id= :x")
	public List<GuideComment> findByGuide(@Param("x") Long id);

}
