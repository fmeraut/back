package com.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.PlaceComment;
import com.repositories.IPlaceCommentRepository;
import com.services.interfaces.IPlaceCommentService;

@Service
public class PlaceCommentServiceImpl implements IPlaceCommentService {

	@Autowired
	private IPlaceCommentRepository placeCommentRepository;

	@Override
	public PlaceComment savePlaceComment(PlaceComment placeComment) {
		// TODO Auto-generated method stub
		return placeCommentRepository.save(placeComment);
	}

	@Override
	public List<PlaceComment> findAll() {
		// TODO Auto-generated method stub
		return placeCommentRepository.findAll();
	}

	@Override
	public PlaceComment findOne(Long id) {
		// TODO Auto-generated method stub
		return placeCommentRepository.findById(id).get();
	}

	@Override
	public void deletePlaceComment(Long id) {
		// TODO Auto-generated method stub
		placeCommentRepository.deleteById(id);
	}

}
