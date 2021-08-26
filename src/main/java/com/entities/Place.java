package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Place implements Serializable {
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
	private String region;
	private String city;
	private String description;
	private String adress;
	private String schedules;
	private String cost;
	private int interet;
	private byte[] image;
	private double rating;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "fk_id_placeType",referencedColumnName = "id")
	private PlaceType placeType;
	
	@JsonBackReference
	@OneToMany
	@JoinColumn(name = "fk_id_place",referencedColumnName = "id")
	private List<PlaceComment> comments;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "assoc_guide_place", joinColumns = @JoinColumn(name = "id_place"), inverseJoinColumns = @JoinColumn(name = "id_guide"))
	private List<Guide> guides;

}// end class
