package com.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Mail;
import com.entities.User;
import com.services.impl.MailService;
import com.services.impl.UserService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionMail")
public class MailController {
	
	@Autowired
	MailService mailService;
	@Autowired
	UserService userService;

	@PostMapping(value = "/mail")
	public void sendMail(@RequestBody Mail mail) {
		
		List<User> users=userService.findAbo();
		List<String> mails=new ArrayList<String>();
		for(User u:users) {
			mails.add(u.getMail());
		}
		Session session=mailService.setupServerProperties();
		MimeMessage mimemessage;
		try {
			mimemessage = mailService.draftMail(mails, mail.getSub(), mail.getTxt());
			mailService.sendMail(session, mimemessage);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
