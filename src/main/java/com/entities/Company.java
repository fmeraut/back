package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "COMPANY")
@Entity

public class Company implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double rating;
	private Date date;
	
	@OneToMany(mappedBy = "company",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<CompanyComments> companyComments;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "companyType",  referencedColumnName = "id")
	private CompanyType companyType;
	

}
