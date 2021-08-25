package com.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Mail;
import com.services.impl.MailService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionMail")
public class MailController {
	
	MailService mailService;

	@GetMapping(value = "/mail")
	public void sendMail(@RequestBody Mail mail) {
		mailService.mail(mail.getRec(), mail.getSub(), mail.getTxt());
	}
}
