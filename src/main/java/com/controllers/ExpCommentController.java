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

import com.entities.ExpComment;
import com.services.impl.ExpCommentService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionExpComments")
public class ExpCommentController {

	@Autowired
	ExpCommentService expCommentService;

	@PostMapping("/expComments")
	public ExpComment saveExpComment(@RequestBody ExpComment expComment) {
		return expCommentService.saveExpComment(expComment);
	}

	// @RequestMapping(value = "/expComments", method = RequestMethod.GET)
	@GetMapping("/expComments")
	public List<ExpComment> findAll() {
		return expCommentService.findAll();
	}

	@RequestMapping(value = "/expComments/{idExpComment}", method = RequestMethod.GET)
	// @GetMapping("/expComments/{idExpComment}")
	public ExpComment findOne(@PathVariable("idExpComment") Long id) {
		return expCommentService.findOne(id);
	}


	@DeleteMapping("/expComments/{idExpComment}")
	public void deleteExpComment(@PathVariable("idExpComment") Long id) {
		expCommentService.deleteExpComment(id);
	}
	
	@GetMapping("/expComments/experience/{idExperience}")
	public List<ExpComment> findByExperience(@PathVariable("idExperience") Long id){
		return expCommentService.findByExperience(id);
	}

}
