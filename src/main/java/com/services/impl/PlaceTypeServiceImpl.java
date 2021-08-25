package com.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.PlaceType;
import com.repositories.IPlaceTypeRepository;
import com.services.interfaces.IPlaceTypeService;

@Service
public class PlaceTypeServiceImpl implements IPlaceTypeService {

	@Autowired
	private IPlaceTypeRepository placeTypeRepository;

	@Override
	public PlaceType savePlaceType(PlaceType placeType) {
		// TODO Auto-generated method stub
		return placeTypeRepository.save(placeType);
	}

	@Override
	public List<PlaceType> findAll() {
		// TODO Auto-generated method stub
		return placeTypeRepository.findAll();
	}

	@Override
	public PlaceType findOne(Long id) {
		// TODO Auto-generated method stub
		return placeTypeRepository.findById(id).get();
	}

	@Override
	public void deletePlaceType(Long id) {
		// TODO Auto-generated method stub
		placeTypeRepository.deleteById(id);
	}

}
