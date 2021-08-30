package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonIgnoreProperties
public class Guide implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String country;
	private String text;
	@Lob
	private byte[] images;
	private boolean validated;
	private double rating;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "assoc_user_guide", joinColumns = @JoinColumn(name = "id_guide"), inverseJoinColumns = @JoinColumn(name = "id_user"))
	private List<User> users;
	
	@JsonBackReference(value="lieu-guide")
	@ManyToMany(mappedBy = "guides")
	private List<Place> places;
	
	
	@OneToMany(mappedBy = "guide",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<GuideComment> comments;

}// end class
