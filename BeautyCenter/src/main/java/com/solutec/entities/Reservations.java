package com.solutec.entities;

import java.sql.Time;
import java.time.LocalTime;
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
	private LocalTime HStart;
	private int dureePresta;
	
	
	public Reservations(Long idSalon, Long idUser, Long idPresta, LocalTime hStart, int dureePresta) {
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


	public LocalTime getHStart() {
		return HStart;
	}


	public void setHStart(LocalTime hStart) {
		HStart = hStart;
	}


	public int getDureePresta() {
		return dureePresta;
	}


	public void setDureePresta(int dureePresta) {
		this.dureePresta = dureePresta;
	}


	
	
	

}
