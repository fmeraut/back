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
import com.entities.Guide;
import com.entities.GuideComment;

import com.services.impl.GuideServiceImpl;
import com.services.impl.GuideCommentService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionGuideComments")
public class GuideCommentController {
	
	@Autowired
	GuideCommentService guideCommentService;
	@Autowired
	GuideServiceImpl guideService;
	
	@PostMapping("/guideComments")
	public GuideComment saveGuidecomment(@RequestBody GuideComment guideComment) {
		Guide guide = guideService.findOne(guideComment.getGuide().getId());
		guideComment.setGuide(guide);
		return guideCommentService.saveGuideComment(guideComment);
	}
	
	// @RequestMapping(value = "/expComments", method = RequestMethod.GET)
		@GetMapping("/guideComments")
		public List<GuideComment> findAll() {
			return guideCommentService.findAll();
		}

		@RequestMapping(value = "/guideComments/{idGuideComment}", method = RequestMethod.GET)
		// @GetMapping("/expComments/{idExpComment}")
		public GuideComment findOne(@PathVariable("idGuideComment") Long id) {
			return guideCommentService.findOne(id);
		}


		@DeleteMapping("/guideComments/{idGuideComment}")
		public void deleteGuideComment(@PathVariable("idguideComment") Long id) {
			guideCommentService.deleteGuideComment(id);
		}
		
		@GetMapping("/guideComments/guide/{idGuide}")
		public List<GuideComment> findGuideExperience(@PathVariable("idGuide") Long id){
			return guideCommentService.findByGuideBis(id);
		}

}
