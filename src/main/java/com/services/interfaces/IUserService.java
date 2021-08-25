package com.services.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.entities.User;

public interface IUserService {

	public User saveUser(User user);

	public List<User> findAll();

	public User findOne(Long id);

	public void deleteUser(Long id);

	public User findByUsername(String username);

	public User findByNom(String nom);

	public User findByPrenom(String prenom);

	public User findByMail(String mail);

	@Query("select u from User u where u.AboNews=1")
	public List<User> findAbo();

}
