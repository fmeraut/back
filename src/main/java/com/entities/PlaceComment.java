package com.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PlaceComment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String text;
	private double note;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_place",referencedColumnName = "id")
	private Place place;
	
}// end class