package com.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.ExpComment;
import com.repositories.IExpCommentRepository;
import com.services.interfaces.IExpCommentService;

@Service
public class ExpCommentService implements IExpCommentService{
	
	@Autowired
	IExpCommentRepository expCommentRepository;

	@Override
	public ExpComment saveExpComment(ExpComment expComment) {

		return expCommentRepository.save(expComment);
	}

	@Override
	public List<ExpComment> findAll() {

		return expCommentRepository.findAll();
	}

	@Override
	public ExpComment findOne(Long id) {
		return expCommentRepository.findById(id).get();
	}

	@Override
	public void deleteExpComment(Long id) {
		expCommentRepository.deleteById(id);
	}

}
