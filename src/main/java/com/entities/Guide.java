package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
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
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "assoc_user_guide", joinColumns = @JoinColumn(name = "id_guide"), inverseJoinColumns = @JoinColumn(name = "id_user"))
	private List<User> users;
	
	@JsonBackReference
	@ManyToMany(mappedBy = "guides")
	private List<Place> places;

}// end class
