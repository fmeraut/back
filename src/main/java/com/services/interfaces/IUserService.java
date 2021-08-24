package com.services.interfaces;

import java.util.List;

import com.entities.User;

public interface IUserService {
	
	public User saveUser(User user);

	public List<User> findAll();

	public User findOne(Long id);

	public void deleteUser(Long id);

}
