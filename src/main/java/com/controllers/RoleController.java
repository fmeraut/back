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

import com.entities.Role;
import com.services.impl.RoleService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionRoles")
public class RoleController {

	@Autowired
	RoleService roleService;

	@PostMapping("/roles")
	public Role saveRole(@RequestBody Role role) {
		return roleService.saveRole(role);
	}

	// @RequestMapping(value = "/roles", method = RequestMethod.GET)
	@GetMapping("/roles")
	public List<Role> findAll() {
		return roleService.findAll();
	}

	@RequestMapping(value = "/roles/{idRole}", method = RequestMethod.GET)
	// @GetMapping("/roles/{idRole}")
	public Role findOne(@PathVariable("idRole") Long id) {
		return roleService.findOne(id);
	}


	@DeleteMapping("/roles/{idRole}")
	public void deleteRole(@PathVariable("idRole") Long id) {
		roleService.deleteRole(id);
	}

}
