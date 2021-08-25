package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.PlaceType;

@Repository
public interface IPlaceTypeRepository extends JpaRepository<PlaceType, Long> {

}
