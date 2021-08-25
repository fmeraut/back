package com.services.interfaces;

import java.util.List;

import com.entities.PlaceType;

public interface IPlaceTypeService {
	public PlaceType savePlaceType(PlaceType placeType);
	
	public List<PlaceType> findAll();
	
	public PlaceType findOne(Long id);
	
	public void deletePlaceType(Long id);
}
