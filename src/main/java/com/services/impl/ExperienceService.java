package com.services.impl;

import java.util.ArrayList;
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

	@Override
	public List<Experience> findByCountry(String country) {
		// TODO Auto-generated method stub
		return experienceRepository.findByCountry(country);
	}

	@Override
	public List<Experience> findByTitle(String title) {
		// TODO Auto-generated method stub
		return experienceRepository.findByTitle(title);
	}

	@Override
	public List<Experience> findUnvalidated() {
		return experienceRepository.findUnvalidated();
	}
	
	@Override
	public List<Experience> findvalidated() {
		return experienceRepository.findvalidated();
	}

	@Override
	public void validate(Long id) {
		experienceRepository.validate(id);
		
	}

	@Override
	public List<Experience> findTop() {
		return experienceRepository.findTop();
	}
	
	@Override
	public List<Experience> findTop4() {
		List<Experience> list=experienceRepository.findTop();
		List<Experience> top=new ArrayList<Experience>();
		for(int i=0;i<=3 && i<list.size();i++) {
			top.add(list.get(i));
		}
		return top;
	}

	@Override
	public List<Experience> findCountryList() {
		List<Experience> list=experienceRepository.findCountryList();
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				if(list.get(i).getCountry().equals(list.get(j).getCountry())) {
					list.remove(j);
				}
			}
		}
		return list;
	}


}

