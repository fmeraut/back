package com.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Role;
import com.repositories.IRoleRepository;
import com.services.interfaces.IRoleService;

@Service
public class RoleService implements IRoleService{
	
	@Autowired
	IRoleRepository roleRepository;

	@Override
	public Role saveRole(Role role) {

		return roleRepository.save(role);
	}

	@Override
	public List<Role> findAll() {

		return roleRepository.findAll();
	}

	@Override
	public Role findOne(Long id) {
		return roleRepository.findById(id).get();
	}

	@Override
	public void deleteRole(Long id) {
		roleRepository.deleteById(id);
	}

}
