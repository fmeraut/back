package com.services.interfaces;

import java.util.List;

import com.entities.CompanyComments;



public interface ICompanyCommentsService {
	public CompanyComments saveCompanyComment(CompanyComments companyComments);

	public List<CompanyComments> findAll();

	public CompanyComments findOne(Long id);

	public void deleteCompanyComment(Long id);

}
