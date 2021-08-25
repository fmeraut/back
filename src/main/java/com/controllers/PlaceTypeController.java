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

import com.entities.PlaceType;
import com.services.interfaces.IPlaceTypeService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionPlaceTypes")
public class PlaceTypeController {

	@Autowired
	IPlaceTypeService placeTypeService;

	@PostMapping("/placeTypes")
	public PlaceType savePlaceType(@RequestBody PlaceType placeType) {
		return placeTypeService.savePlaceType(placeType);
	}

	@GetMapping("/placeTypes")
	public List<PlaceType> findAll() {
		return placeTypeService.findAll();
	}

	@RequestMapping(value = "/placeTypes/{idPlaceType}", method = RequestMethod.GET)
	public PlaceType findOne(@PathVariable("idPlaceType") Long id) {
		return placeTypeService.findOne(id);
	}

	@DeleteMapping("/placeTypes/{idPlaceType}")
	public void deletePlaceType(@PathVariable("idPlaceType") Long id) {
		placeTypeService.deletePlaceType(id);
	}
}
