package com.solutec.entities;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Reservations {
	@Id @GeneratedValue
	private Long id;
	
	private Long idsalon;
	private Long iduser;
	private Long idpresta;
	private int dureepresta;
	
	@Column
	   @Convert(converter = ConvertionLocalDateTime.class)
		private LocalDateTime hstart;
	
	
	
	
	public Reservations(Long idSalon, Long idUser, Long idPresta, LocalDateTime hstart, int dureePresta) {
		super();
		this.idsalon = idSalon;
		this.iduser = idUser;
		this.idpresta = idPresta;
		this.hstart = hstart;
		this.dureepresta = dureePresta;
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


	public Long getIdsalon() {
		return idsalon;
	}


	public void setIdsalon(Long idsalon) {
		this.idsalon = idsalon;
	}


	public Long getIduser() {
		return iduser;
	}


	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}


	public Long getIdpresta() {
		return idpresta;
	}


	public void setIdpresta(Long idpresta) {
		this.idpresta = idpresta;
	}


	public int getDureepresta() {
		return dureepresta;
	}


	public void setDureepresta(int dureepresta) {
		this.dureepresta = dureepresta;
	}


	public LocalDateTime getHstart() {
		return hstart;
	}


	public void setHstart(LocalDateTime hstart) {
		this.hstart = hstart;
	}




	
	
	
	

}
