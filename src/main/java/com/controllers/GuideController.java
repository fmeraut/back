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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.entities.Guide;
import com.entities.Place;

import com.services.interfaces.IGuideService;
import com.services.interfaces.IPlaceService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionGuides")
public class GuideController {

	@Autowired
	IGuideService guideService;
	@Autowired
	IPlaceService placeService;

//	@PostMapping("/guides")
//	public Guide saveGuide(@RequestBody Guide guide) {
//		return guideService.saveGuide(guide);
//	}
	
	@PostMapping(value="/guides")
	public String saveGuide(@RequestParam String title, @RequestParam String country, 
			@RequestParam String text, @RequestParam MultipartFile photos, 
			@RequestParam String rating){ 
		try {
			Guide guide=new Guide();
			guide.setTitle(title);
			guide.setCountry(country);
			guide.setText(text);
			guide.setImages(photos.getBytes());
			guide.setRating(Double.parseDouble(rating));
			guideService.saveGuide(guide);
			return "File uploaded successfully!";
		} catch (Exception ex){
			ex.printStackTrace();
			return "Fail!";
		}
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
	
	@GetMapping("/guides/top")
	public List<Guide> findTop() {
		return guideService.findTop();
	}
	
	@GetMapping("/guides/top4")
	public List<Guide> findTop4() {
		return guideService.findTop4();
	}
	
	@GetMapping("/guides/countryList")
	public List<Guide> findCountryList(){
		return guideService.findCountryList();
	}
	
	@PutMapping("/guides/asso")
	public void associatePlace(@RequestBody Guide guide) {
		Guide currentGuide = guideService.findOne(guide.getId());
		Place assoPlace = placeService.findOne(guide.getPlaces().get(0).getId());
		List<Place> places = currentGuide.getPlaces();
		places.add(assoPlace);
		currentGuide.setPlaces(places);
	}
}
