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
	private String adresse;
	private String telephone;
	

	public Salon() {
		super();
	}

	public Salon(String nomSalon, Date dateSalon, String contact, String adresse, String telephone) {
		super();
		this.nomSalon = nomSalon;
		this.dateSalon = dateSalon;
		this.contact = contact;
		this.adresse = adresse;
		this.telephone = telephone;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getAdresse() {
		return adresse;
	}




	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}




	public String getTelephone() {
		return telephone;
	}




	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}




	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
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
