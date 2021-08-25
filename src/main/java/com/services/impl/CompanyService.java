package com.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Company;
import com.repositories.ICompanyRepository;
import com.services.interfaces.ICompanyService;

@Service
public class CompanyService implements ICompanyService {
	
	@Autowired
	ICompanyRepository companyRepository;

	@Override
	public Company saveCompany(Company company) {
		
		return companyRepository.save(company);
	}

	@Override
	public List<Company> findAll() {
		
		return companyRepository.findAll();
	}

	@Override
	public Company findOne(Long id) {
		
		return companyRepository.findById(id).get();
	}

	@Override
	public void deleteCompany(Long id) {
		companyRepository.deleteById(id);
		
	}

}
