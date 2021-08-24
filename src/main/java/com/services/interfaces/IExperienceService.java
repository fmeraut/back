package com.services.interfaces;

import java.util.List;

import com.entities.Experience;

public interface IExperienceService {
	
	public Experience saveExperience(Experience experience);

	public List<Experience> findAll();

	public Experience findOne(Long id);

	public void deleteExperience(Long id);

}
