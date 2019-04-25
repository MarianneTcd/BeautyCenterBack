package com.solutec.entities;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Config {

	@Id @GeneratedValue
	private Long idConfig;
	private Long idSalon; 
	private int nbPersonnelTotal;
	private LocalTime HStart;
	private LocalTime HEnd;
	
	
	public Config(Long idSalon, int nbPersonnelTotal, LocalTime hStart,LocalTime hEnd) {
		super();
		
		this.idSalon = idSalon;
		this.HStart = hStart;
		this.HEnd = hEnd;
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
		return HStart;
	}


	public void setHStart(LocalTime hStart) {
		HStart = hStart;
	}


	public LocalTime getHEnd() {
		return HEnd;
	}


	public void setHEnd(LocalTime hEnd) {
		HEnd = hEnd;
	}


	public int getNbPersonnelTotal() {
		return nbPersonnelTotal;
	}


	public void setNbPersonnelTotal(int nbPersonnelTotal) {
		this.nbPersonnelTotal = nbPersonnelTotal;
	}
	

}
