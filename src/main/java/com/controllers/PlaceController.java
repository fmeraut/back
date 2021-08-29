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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.entities.Place;
import com.entities.Place;
import com.entities.Place;
import com.services.interfaces.IGuideService;
import com.services.interfaces.IPlaceService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionPlaces")
public class PlaceController {

	@Autowired
	IPlaceService placeService;
	@Autowired
	IGuideService guideService;

//	@PostMapping("/places")
//	public Place savePlace(@RequestBody Place place) {
//		return placeService.savePlace(place);
//	}
	
	@PostMapping(value="/places")
	public String savePlace(@RequestParam String title, @RequestParam String country, 
			@RequestParam String adress, @RequestParam String city, @RequestParam String region, @RequestParam String schedules,  
			@RequestParam String cost, @RequestParam String description, @RequestParam MultipartFile photos,   
			@RequestParam String rating){ 
		try {
			Place place=new Place();
			place.setTitle(title);
			place.setCountry(country);
			place.setAdress(adress);
			place.setCity(city);
			place.setRegion(region);
			place.setSchedules(schedules);
			place.setDescription(description);
			place.setCost(cost);
			place.setPhotos(photos.getBytes());
			place.setRating(Double.parseDouble(rating));
			placeService.savePlace(place);
			return "File uploaded successfully!";
		} catch (Exception ex){
			ex.printStackTrace();
			return "Fail!";
		}
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

	@RequestMapping(value = "/places/country/{country}", method = RequestMethod.GET)
	public List<Place> findPlaceByCountry(@PathVariable("country") String country) {
		return placeService.findPlaceByCountry(country);
	}
	
	@RequestMapping(value = "/places/title/{title}", method = RequestMethod.GET)
	public List<Place> findPlaceByTitle(@PathVariable("title") String title) {
		return placeService.findPlaceByTitle(title);
	}
	
	@GetMapping("/places/guide/{idGuide}")
	public List<Place> findByGuide(@PathVariable("idGuide") Long id){
		return placeService.findByGuide(id);
	}
	
	
	@GetMapping("/places/top")
	public List<Place> findTop() {
		return placeService.findTop();
	}
	
	@GetMapping("/places/top4")
	public List<Place> findTop4() {
		return placeService.findTop4();
	}
	
	@GetMapping("/places/countryList")
	public List<Place> findCountryList(){
		return placeService.findCountryList();
	}

}
