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

import com.entities.User;
import com.services.impl.UserService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionUsers")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/users")
	public List<User> findAll() {
		return userService.findAll();
	}

	@RequestMapping(value = "/users/{idUser}", method = RequestMethod.GET)
	public User findOne(@PathVariable("idUser") Long id) {
		return userService.findOne(id);
	}


	@DeleteMapping("/users/{idUser}")
	public void deleteUser(@PathVariable("idUser") Long id) {
		userService.deleteUser(id);
	}
	
	@GetMapping("/users/{nom}")
	public User findNom(@PathVariable("nom") String nom) {
		return userService.findByNom(nom);
	}
	
	@GetMapping("/users/{prenom}")
	public User findPrenom(@PathVariable("prenom") String prenom) {
		return userService.findByPrenom(prenom);
	}
	
	@GetMapping("/users/{username}")
	public User findUsername(@PathVariable("username") String username) {
		return userService.findByUsername(username);
	}
	
	@GetMapping("/users/{mail}")
	public User findMail(@PathVariable("mail") String mail) {
		return userService.findByMail(mail);
	}
	
	@GetMapping("/abos")
	public List<User> findAbo() {
		return userService.findAbo();
	}

}
