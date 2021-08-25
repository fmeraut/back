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

import com.entities.CompanyType;
import com.services.impl.CompanyTypeService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionCompanyType")
public class CompanyTypeController {
	@Autowired
	CompanyTypeService companyTypeService;

	@PostMapping("/companyTypes")
	public CompanyType saveCompanyType(@RequestBody CompanyType companyType) {
		return companyTypeService.saveCompanyType(companyType);
	}

	// @RequestMapping(value = "/companyTypes", method = RequestMethod.GET)
	@GetMapping("/companyTypes")
	public List<CompanyType> findAll() {
		return companyTypeService.findAll();
	}

	@RequestMapping(value = "/companyTypes/{idCompanyTypes}", method = RequestMethod.GET)
	// @GetMapping("/companyTypes/{idCompanyTypes}")
	public CompanyType findOne(@PathVariable("idCompanyTypes") Long id) {
		return companyTypeService.findOne(id);
	}


	@DeleteMapping("/companyTypes/{idCompanyTypes}")
	public void deleteCompanyTypes(@PathVariable("idCompanyTypes") Long id) {
		companyTypeService.deleteCompanyType(id);
	}


}
