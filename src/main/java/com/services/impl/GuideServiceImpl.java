package com.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Experience;
import com.entities.Guide;
import com.repositories.IGuideRepository;
import com.services.interfaces.IGuideService;

@Service
public class GuideServiceImpl implements IGuideService{

	@Autowired
	private IGuideRepository guideRepository;
	
	@Override
	public Guide saveGuide(Guide guide) {
		// TODO Auto-generated method stub
		return guideRepository.save(guide);
	}

	@Override
	public List<Guide> findAll() {
		// TODO Auto-generated method stub
		return guideRepository.findAll();
	}

	@Override
	public Guide findOne(Long id) {
		// TODO Auto-generated method stub
		return guideRepository.findById(id).get();
	}

	@Override
	public void deleteGuide(Long id) {
		// TODO Auto-generated method stub
		guideRepository.deleteById(id);
	}

	@Override
	public List<Guide> findGuideByCountry(String country) {
		// TODO Auto-generated method stub
		return guideRepository.findGuideByCountry(country);
	}

	@Override
	public List<Guide> findGuideByTitle(String title) {
		// TODO Auto-generated method stub
		return guideRepository.findGuideByTitle(title);
	}

	@Override
	public List<Guide> findUnvalidated() {
		return guideRepository.findUnvalidated();
	}

	@Override
	public void validate(Long id) {
		guideRepository.validate(id);
		
	}
	
	@Override
	public List<Guide> findTop() {
		return guideRepository.findTop();
	}
	
	@Override
	public List<Guide> findTop4() {
		List<Guide> list=guideRepository.findTop();
		List<Guide> top=new ArrayList<Guide>();
		for(int i=0;i<=3 && i<list.size();i++) {
			top.add(list.get(i));
		}
		return top;
	}
	
	@Override
	public List<Guide> findCountryList() {
		List<Guide> list=guideRepository.findCountryList();
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
