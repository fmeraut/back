package com.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.User;
import com.services.impl.UserService;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@CrossOrigin
	@GetMapping("/user")
	public User login(Principal principal) {
		return userService.findByUsername(principal.getName());
	}

}
