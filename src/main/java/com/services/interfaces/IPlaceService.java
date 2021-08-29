package com.services.interfaces;

import java.util.List;

import com.entities.Place;

public interface IPlaceService {
	public Place savePlace(Place place);
	
	public List<Place> findAll();
	
	public Place findOne(Long id);
	
	public void deletePlace(Long id);
	
	public List<Place> findPlaceByCountry(String country);
	
	public List<Place> findPlaceByTitle(String title);
	
	public List<Place> findByGuide(Long id);
}
