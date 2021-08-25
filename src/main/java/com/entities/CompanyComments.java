package com.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table
@Entity
public class CompanyComments implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String text;
	private double note;
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "FK_COMPANY",  referencedColumnName = "id")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_user",referencedColumnName = "id")
	private User user;
	

}
