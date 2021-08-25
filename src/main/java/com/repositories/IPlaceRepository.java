package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Place;

@Repository
public interface IPlaceRepository extends JpaRepository<Place, Long>{

}
