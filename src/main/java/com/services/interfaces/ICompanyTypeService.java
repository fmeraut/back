package com.services.interfaces;

import java.util.List;


import com.entities.CompanyType;

public interface ICompanyTypeService {
	public CompanyType saveCompanyType(CompanyType companyType);

	public List<CompanyType> findAll();

	public CompanyType findOne(Long id);

	public void deleteCompanyType(Long id);

}
