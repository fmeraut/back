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

import com.entities.Experience;
import com.services.impl.ExperienceService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionExperiences")
public class ExperienceController {

	@Autowired
	ExperienceService experienceService;

	@PostMapping("/experiences")
	public Experience saveExperience(@RequestBody Experience experience) {
		return experienceService.saveExperience(experience);
	}

	// @RequestMapping(value = "/experiences", method = RequestMethod.GET)
	@GetMapping("/experiences")
	public List<Experience> findAll() {
		return experienceService.findAll();
	}

	@RequestMapping(value = "/experiences/{idExperience}", method = RequestMethod.GET)
	// @GetMapping("/experiences/{idExperience}")
	public Experience findOne(@PathVariable("idExperience") Long id) {
		return experienceService.findOne(id);
	}


	@DeleteMapping("/experiences/{idExperience}")
	public void deleteExperience(@PathVariable("idExperience") Long id) {
		experienceService.deleteExperience(id);
	}

}
