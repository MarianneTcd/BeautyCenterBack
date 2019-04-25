package com.solutec.entities;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Config {

	@Id @GeneratedValue
	private Long idConfig;
	private Long idSalon; 
	private int nbPersonnelTotal;
	
	@Column
	   @Convert(converter = ConvertionLocalDateTime.class)
		private LocalTime hStart;
	
	@Column
	   @Convert(converter = ConvertionLocalDateTime.class)
		private LocalTime hEnd;
	
	public Config(Long idSalon, int nbPersonnelTotal, LocalTime hStart ,LocalTime hEnd) {
		super();
		
		this.idSalon = idSalon;
		this.hStart = hStart;
		this.hEnd = hEnd;
		this.nbPersonnelTotal = nbPersonnelTotal;
	}


	public Config() {
		super();
	}
	

	public Long getIdConfig() {
		return idConfig;
	}
	public void setIdConfig(Long idConfig) {
		this.idConfig = idConfig;
	}
	public Long getIdSalon() {
		return idSalon;
	}
	public void setIdSalon(Long idSalon) {
		this.idSalon = idSalon;
	}


	public LocalTime getHStart() {
		return hStart;
	}


	public void setHStart(LocalTime hStart) {
		hStart = hStart;
	}


	public LocalTime getHEnd() {
		return hEnd;
	}


	public void setHEnd(LocalTime hEnd) {
		hEnd = hEnd;
	}


	public int getNbPersonnelTotal() {
		return nbPersonnelTotal;
	}


	public void setNbPersonnelTotal(int nbPersonnelTotal) {
		this.nbPersonnelTotal = nbPersonnelTotal;
	}
	

}
