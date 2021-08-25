package com.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.CompanyType;

import com.repositories.ICompanyTypeRepository;
import com.services.interfaces.ICompanyTypeService;

@Service
public class CompanyTypeService implements ICompanyTypeService{
	
	@Autowired
	ICompanyTypeRepository companyTypeRepository;

	@Override
	public CompanyType saveCompanyType(CompanyType companyType) {
		
		return companyTypeRepository.save(companyType);
	}

	@Override
	public List<CompanyType> findAll() {
		
		return companyTypeRepository.findAll();
	}

	@Override
	public CompanyType findOne(Long id) {
		
		return companyTypeRepository.findById(id).get();
	}

	@Override
	public void deleteCompanyType(Long id) {
		companyTypeRepository.deleteById(id);
		
		
	}

}
