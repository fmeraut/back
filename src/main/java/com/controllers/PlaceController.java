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

import com.entities.Place;
import com.services.interfaces.IPlaceService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionPlaces")
public class PlaceController {
	
	@Autowired
	IPlaceService placeService;

	@PostMapping("/places")
	public Place savePlace(@RequestBody Place place) {
		return placeService.savePlace(place);
	}

	@GetMapping("/places")
	public List<Place> findAll() {
		return placeService.findAll();
	}

	@RequestMapping(value = "/places/{idPlace}", method = RequestMethod.GET)
	public Place findOne(@PathVariable("idPlace") Long id) {
		return placeService.findOne(id);
	}

	@DeleteMapping("/places/{idPlace}")
	public void deletePlace(@PathVariable("idPlace") Long id) {
		placeService.deletePlace(id);
	}
}