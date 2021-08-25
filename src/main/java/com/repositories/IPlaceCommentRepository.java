package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.PlaceComment;

@Repository
public interface IPlaceCommentRepository extends JpaRepository<PlaceComment, Long>{

}
