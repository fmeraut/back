package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
public class Experience implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String text;
	@Lob
	private byte[] photos;
	private String[] videos;
	private double rating;
	
	@OneToMany
	@JoinColumn(name = "fk_id_experience",referencedColumnName = "id")
	private List<ExpComment> comments;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_user",referencedColumnName = "id")
	private User user;

}
