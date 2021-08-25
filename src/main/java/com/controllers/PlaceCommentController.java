package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entities.PlaceComment;
import com.services.interfaces.IPlaceCommentService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionPlaceComments")
public class PlaceCommentController {

	@Autowired
	IPlaceCommentService placeCommentService;

	@PostMapping("/placeComments")
	public PlaceComment savePlaceComment(@RequestBody PlaceComment placeComment) {
		return placeCommentService.savePlaceComment(placeComment);
	}

	@GetMapping("/placeComments")
	public List<PlaceComment> findAll() {
		return placeCommentService.findAll();
	}

	@RequestMapping(value = "/placeComments/{idPlaceComment}", method = RequestMethod.GET)
	public PlaceComment findOne(@PathVariable("idPlaceComment") Long id) {
		return placeCommentService.findOne(id);
	}

	@DeleteMapping("/placeComments/{idPlaceComment}")
	public void deletePlaceComment(@PathVariable("idPlaceComment") Long id) {
		placeCommentService.deletePlaceComment(id);
	}
}