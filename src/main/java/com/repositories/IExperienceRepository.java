package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Experience;

@Repository
public interface IExperienceRepository extends JpaRepository<Experience, Long>{

}
