package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Experience;
import com.entities.Guide;
import com.services.interfaces.IGuideService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionGuides")
public class GuideController {

	@Autowired
	IGuideService guideService;

	@PostMapping("/guides")
	public Guide saveGuide(@RequestBody Guide guide) {
		return guideService.saveGuide(guide);
	}

	@GetMapping("/guides")
	public List<Guide> findAll() {
		return guideService.findAll();
	}

	@RequestMapping(value = "/guides/{idGuide}", method = RequestMethod.GET)
	public Guide findOne(@PathVariable("idGuide") Long id) {
		return guideService.findOne(id);
	}

	@DeleteMapping("/guides/{idGuide}")
	public void deleteGuide(@PathVariable("idGuide") Long id) {
		guideService.deleteGuide(id);
	}
	
	@RequestMapping(value = "/guides/country/{country}", method = RequestMethod.GET)
	public List<Guide> findGuideByCountry(@PathVariable("country") String country){
		return guideService.findGuideByCountry(country);
	}
	
	@RequestMapping(value = "/guides/title/{title}", method = RequestMethod.GET)
	public List<Guide> findGuideByTitle(@PathVariable("title") String title){
		return guideService.findGuideByTitle(title);
	}
	
	@GetMapping("/guides/unvalidated")
	public List<Guide> findUnvalidated(){
		return guideService.findUnvalidated();
	}
	
	@PutMapping("/guides/validate/{idGuide}")
	public void validate(@PathVariable("idGuide") Long id) {
		guideService.validate(id);
	}
}
