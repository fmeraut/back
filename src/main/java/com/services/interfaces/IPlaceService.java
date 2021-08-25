package com.services.interfaces;

import java.util.List;

import com.entities.Place;

public interface IPlaceService {
	public Place savePlace(Place place);
	
	public List<Place> findAll();
	
	public Place findOne(Long id);
	
	public void deletePlace(Long id);
}