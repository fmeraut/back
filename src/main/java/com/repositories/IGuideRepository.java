package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Guide;

@Repository
public interface IGuideRepository extends JpaRepository<Guide, Long>{

}
