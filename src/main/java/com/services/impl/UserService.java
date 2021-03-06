package com.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.User;
import com.repositories.IUserRepository;
import com.services.interfaces.IUserService;

@Service
public class UserService implements IUserService{
	
	@Autowired
	IUserRepository userRepository;

	@Override
	public User saveUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {

		return userRepository.findAll();
	}

	@Override
	public User findOne(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByNom(String nom) {
		return userRepository.findByNom(nom);
	}

	@Override
	public User findByPrenom(String prenom) {
		return userRepository.findByPrenom(prenom);
	}

	@Override
	public User findByMail(String mail) {
		return userRepository.findByMail(mail);
	}

	@Override
	public List<User> findAbo() {
		return userRepository.findAbo();
	}

}
