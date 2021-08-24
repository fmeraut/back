package com.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Experience;
import com.repositories.IExperienceRepository;
import com.services.interfaces.IExperienceService;

@Service
public class ExperienceService implements IExperienceService{
	
	@Autowired
	IExperienceRepository experienceRepository;

	@Override
	public Experience saveExperience(Experience experience) {

		return experienceRepository.save(experience);
	}

	@Override
	public List<Experience> findAll() {

		return experienceRepository.findAll();
	}

	@Override
	public Experience findOne(Long id) {
		return experienceRepository.findById(id).get();
	}

	@Override
	public void deleteExperience(Long id) {
		experienceRepository.deleteById(id);
	}

}

