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

import com.entities.Company;
import com.services.impl.CompanyService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionCompanies")
public class CompanyController {
	
	@Autowired
	CompanyService companyService;

	@PostMapping("/companies")
	public Company saveCompany(@RequestBody Company company) {
		return companyService.saveCompany(company);
	}

	// @RequestMapping(value = "/companies", method = RequestMethod.GET)
	@GetMapping("/companies")
	public List<Company> findAll() {
		return companyService.findAll();
	}

	@RequestMapping(value = "/companies/{idCompany}", method = RequestMethod.GET)
	// @GetMapping("/companies/{idCompany}")
	public Company findOne(@PathVariable("idCompany") Long id) {
		return companyService.findOne(id);
	}


	@DeleteMapping("/companies/{idCompany}")
	public void deleteCompany(@PathVariable("idCompany") Long id) {
		companyService.deleteCompany(id);
	}

}
