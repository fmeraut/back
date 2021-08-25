package com.services.interfaces;

import java.util.List;

import com.entities.Guide;

public interface IGuideService {
	public Guide saveGuide(Guide guide);
	
	public List<Guide> findAll();
	
	public Guide findOne(Long id);
	
	public void deleteGuide(Long id);
	
	public List<Guide> findGuideByCountry(String country);
	
	public List<Guide> findGuideByTitle(String title);
	
	public List<Guide> findUnvalidated();
	
	public void validate(Long id);
	
}
