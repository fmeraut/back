package com.services.interfaces;

import java.util.List;

import com.entities.Role;

public interface IRoleService {
	
	public Role saveRole(Role role);

	public List<Role> findAll();

	public Role findOne(Long id);

	public void deleteRole(Long id);

}
