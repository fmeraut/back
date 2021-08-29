package com.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.GuideComment;
import com.repositories.IGuideCommentRepository;
import com.services.interfaces.IGuideCommentService;

@Service
public class GuideCommentService implements IGuideCommentService{
	
	@Autowired
	IGuideCommentRepository guideCommentRepository;

	@Override
	public GuideComment saveGuideComment(GuideComment guideComment) {
		
		return guideCommentRepository.save(guideComment);
	}

	@Override
	public List<GuideComment> findAll() {
	
		return guideCommentRepository.findAll();
	}

	@Override
	public GuideComment findOne(Long id) {
		
		return guideCommentRepository.findById(id).get();
	}

	@Override
	public void deleteGuideComment(Long id) {
		guideCommentRepository.deleteById(id);
		
	}

	@Override
	public List<GuideComment> findByGuideBis(Long id) {
		
		return guideCommentRepository.findByGuide(id);
	}

}
