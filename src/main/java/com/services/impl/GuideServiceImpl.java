package com.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
