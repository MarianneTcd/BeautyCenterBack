package com.solutec.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reservations {
	@Id @GeneratedValue
	private Long id;
	
	private Long idSalon;
	private Long idUser;
	private Long idPresta;
	private Date HStart;
	private Date dureePresta;
	
	
	public Reservations(Long idSalon, Long idUser, Long idPresta, Date hStart, Date dureePresta) {
		super();
		this.idSalon = idSalon;
		this.idUser = idUser;
		this.idPresta = idPresta;
		HStart = hStart;
		this.dureePresta = dureePresta;
	}


	public Reservations() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getIdSalon() {
		return idSalon;
	}


	public void setIdSalon(Long idSalon) {
		this.idSalon = idSalon;
	}


	public Long getIdUser() {
		return idUser;
	}


	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}


	public Long getIdPresta() {
		return idPresta;
	}


	public void setIdPresta(Long idPresta) {
		this.idPresta = idPresta;
	}


	public Date getHStart() {
		return HStart;
	}


	public void setHStart(Date hStart) {
		HStart = hStart;
	}


	public Date getDureePresta() {
		return dureePresta;
	}


	public void setDureePresta(Date dureePresta) {
		this.dureePresta = dureePresta;
	}
	
	

}
