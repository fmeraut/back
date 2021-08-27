package com.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.entities.Role;
import com.entities.User;
import com.model.UserDetail;

@Service
public class AppUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userService.findByUsername(username);
		Set<Role> roles=user.getRoles();
		Set<GrantedAuthority> authorities=new HashSet<GrantedAuthority>();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getLibelle()));
		}
		UserDetail userDetail=new UserDetail();
		userDetail.setUser(user);
		userDetail.setAuthorities(authorities);
		return userDetail;
	}

}
