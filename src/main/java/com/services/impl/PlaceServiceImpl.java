package com.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Place;
import com.repositories.IPlaceRepository;
import com.services.interfaces.IPlaceService;

@Service
public class PlaceServiceImpl implements IPlaceService {

	@Autowired
	private IPlaceRepository placeRepository;

	@Override
	public Place savePlace(Place place) {
		// TODO Auto-generated method stub
		return placeRepository.save(place);
	}

	@Override
	public List<Place> findAll() {
		// TODO Auto-generated method stub
		return placeRepository.findAll();
	}

	@Override
	public Place findOne(Long id) {
		// TODO Auto-generated method stub
		return placeRepository.findById(id).get();
	}

	@Override
	public void deletePlace(Long id) {
		// TODO Auto-generated method stub
		placeRepository.deleteById(id);
	}

	@Override
	public List<Place> findPlaceByCountry(String country) {
		// TODO Auto-generated method stub
		return placeRepository.findPlaceByCountry(country);
	}

	@Override
	public List<Place> findPlaceByTitle(String title) {
		// TODO Auto-generated method stub
		return placeRepository.findPlaceByTitle(title);
	}

}
