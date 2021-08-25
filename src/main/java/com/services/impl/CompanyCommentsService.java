package com.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.CompanyComments;
import com.repositories.ICompanyCommentsRepository;
import com.services.interfaces.ICompanyCommentsService;

@Service
public class CompanyCommentsService implements ICompanyCommentsService {
	
	@Autowired
	ICompanyCommentsRepository companyCommentsRepository;

	@Override
	public CompanyComments saveCompanyComment(CompanyComments companyComments) {
		
		return companyCommentsRepository.save(companyComments);
	}

	@Override
	public List<CompanyComments> findAll() {
		
		return companyCommentsRepository.findAll();
	}

	@Override
	public CompanyComments findOne(Long id) {
		// TODO Auto-generated method stub
		return companyCommentsRepository.findById(id).get();
	}

	@Override
	public void deleteCompanyComment(Long id) {
		companyCommentsRepository.deleteById(id);
		
	}

}
