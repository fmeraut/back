package com.services.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.entities.Guide;

public interface IGuideService {
	public Guide saveGuide(Guide guide);
	
	public List<Guide> findAll();
	
	public Guide findOne(Long id);
	
	public void deleteGuide(Long id);
	
	public List<Guide> findGuideByCountry(String country);
	
	public List<Guide> findGuideByTitle(String title);
	
	public List<Guide> findUnvalidated();
	
	public List<Guide> findvalidated();
	
	public void validate(Long id);
	
	public List<Guide> findTop();
	
	public List<Guide> findTop4();
	
	public List<Guide> findCountryList();
	
	public Guide savePlace(Long gid,Long pid);}
