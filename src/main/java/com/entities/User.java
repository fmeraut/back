package com.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String username;
	private String password;
	private String mail;
	private boolean aboNews;
	
	@OneToMany
	@JoinColumn(name = "fk_id_user",referencedColumnName = "id")
	private List<Experience> experiences;
	
	@ManyToMany
	@JoinTable(name = "assoc_role_user", joinColumns = @JoinColumn(name="id_user"), inverseJoinColumns = @JoinColumn(name="id_role"))
	private Set<Role> roles;
	
	@OneToMany
	@JoinColumn(name = "fk_id_user",referencedColumnName = "id")
	private List<CompanyComments> compcomments;
	

}
