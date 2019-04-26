package com.solutec.entities;

import java.util.Date;

import javax.persistence.Column;
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
	private int nbPersonnelSalon;
	private int idManager;
	@Column(name="photo")
	private String photo = "http://www.le-salon-coiffeur.com/images/accueil-2.jpg";
	

	public Salon() {
		super();
	}

	public Salon(String nomSalon, Date dateSalon, String contact, String adresse, String telephone, int nbPersonnelSalon, int idManager, String photo) {
		super();
		this.nomSalon = nomSalon;
		this.dateSalon = dateSalon;
		this.contact = contact;
		this.adresse = adresse;
		this.telephone = telephone;
		this.nbPersonnelSalon = nbPersonnelSalon;
		this.idManager = idManager;
		this.photo = photo;
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
	
	public int getIdManager() {
		return idManager;
	}

	public void setIdManager(int idManager) {
		this.idManager = idManager;
	}

	public void setDateSalon(Date dateSalon) {
		this.dateSalon = dateSalon;
	}

	public int getNbPersonnelSalon() {
		return nbPersonnelSalon;
	}

	public void setNbPersonnelSalon(int nbPersonnelSalon) {
		this.nbPersonnelSalon = nbPersonnelSalon;
	} 
	
	
	
}
