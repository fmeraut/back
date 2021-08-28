package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entities.CompanyComments;
import com.services.impl.CompanyCommentsService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionCompanyComments")
public class CompanyCommentsController {
	
	@Autowired
	CompanyCommentsService companyCommentsService;

	@PostMapping("/companyComments")
	public CompanyComments saveCompanyComments(@RequestBody CompanyComments companyComments) {
		return companyCommentsService.saveCompanyComment(companyComments);
	}

	// @RequestMapping(value = "/companyComments", method = RequestMethod.GET)
	@GetMapping("/companyComments")
	public List<CompanyComments> findAll() {
		return companyCommentsService.findAll();
	}

	@RequestMapping(value = "/companyComments/{idCompanyComments}", method = RequestMethod.GET)
	// @GetMapping("/companyComments/{idCompanyComments}")
	public CompanyComments findOne(@PathVariable("idCompanyComments") Long id) {
		return companyCommentsService.findOne(id);
	}

	@DeleteMapping("/companyComments/{idCompanyComments}")
	public void deleteCompanyComments(@PathVariable("idCompanyComments") Long id) {
		companyCommentsService.deleteCompanyComment(id);
	}
	
	@GetMapping("/companyComments/company/{idCompany}")
	public List<CompanyComments> findByCompany(@PathVariable("idCompany") Long id){
		return companyCommentsService.findByCompany(id);
	}

}
