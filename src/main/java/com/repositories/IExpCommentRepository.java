package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.ExpComment;

@Repository
public interface IExpCommentRepository extends JpaRepository<ExpComment, Long>{

}
