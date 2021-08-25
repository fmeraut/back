package com.services.interfaces;

import java.util.List;

import com.entities.Company;


public interface ICompanyService {
	
	public Company saveCompany(Company company);

	public List<Company> findAll();

	public Company findOne(Long id);

	public void deleteCompany(Long id);


}
