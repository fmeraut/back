package com.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{
	
	public User findByUsername(String username);
	public User findByNom(String username);
	public User findByPrenom(String username);
	public User findByMail(String username);
	
	@Query("select u from User u where u.aboNews=1")
	public List<User> findAbo();

}
