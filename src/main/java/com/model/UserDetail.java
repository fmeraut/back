//package com.model;
//
//import java.util.Collection;
//import java.util.Set;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.entities.User;
//
//public class UserDetail implements UserDetails{
//	
//	private static final long serialVersionUID = 1L;
//	private User utilisateur;
//	Set<GrantedAuthority> authorities = null;
//
//	public User getUser() {
//		return utilisateur;
//	}
//
//	public void setUser(User utilisateur) {
//		this.utilisateur = utilisateur;
//	}
//
//	public void setAuthorities(Set<GrantedAuthority> authorities) {
//		this.authorities = authorities;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//
//		return authorities;
//	}
//
//	@Override
//	public String getPassword() {
//		return utilisateur.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		return utilisateur.getUsername();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//}
