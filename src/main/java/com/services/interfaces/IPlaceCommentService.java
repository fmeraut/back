package com.services.interfaces;

import java.util.List;

import com.entities.PlaceComment;

public interface IPlaceCommentService {
	public PlaceComment savePlaceComment(PlaceComment placeComment);
	
	public List<PlaceComment> findAll();
	
	public PlaceComment findOne(Long id);
	
	public void deletePlaceComment(Long id);
}
