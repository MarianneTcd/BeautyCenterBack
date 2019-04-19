package com.solutec.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Salon {
	@Id @GeneratedValue
	private Long id;
	
	private String nomSalon;
	
	@Temporal(TemporalType.DATE)
	private Date dateSalon;
	private String contact; 


	public Salon() {
		super();
	}




	public Salon(String nomSalon, Date dateSalon, String contact) {
		super();
		this.nomSalon = nomSalon;
		this.dateSalon = dateSalon;
		this.contact = contact;
	}




	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomSalon() {
		return nomSalon;
	}


	public void setNomSalon(String nomSalon) {
		this.nomSalon = nomSalon;
	}


	public Date getDateSalon() {
		return dateSalon;
	}


	public void setDateSalon(Date dateSalon) {
		this.dateSalon = dateSalon;
	} 
	
}
