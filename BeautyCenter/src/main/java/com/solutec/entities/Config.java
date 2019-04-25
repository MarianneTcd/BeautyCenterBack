package com.solutec.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Config {

	@Id @GeneratedValue
	private Long idConfig;
	
	private Long idSalon;
	private int nbPersonnel;
	private Date HStart;
	private Date HEnd;
	
	
	public Config(Long idSalon, int nbPersonnel, Date hStart, Date hEnd) {
		super();
		
		this.idSalon = idSalon;
		this.HStart = hStart;
		this.HEnd = hEnd;
		this.nbPersonnel = nbPersonnel;
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
	public Date getHStart() {
		return HStart;
	}
	public void setHStart(Date hStart) {
		HStart = hStart;
	}
	public Date getHEnd() {
		return HEnd;
	}
	public void setHEnd(Date hEnd) {
		HEnd = hEnd;
	}
	
	public int getNbPersonnel() {
		return nbPersonnel;
	}

	public void setNbPersonnel(int nbPersonnel) {
		this.nbPersonnel = nbPersonnel;
	}
	
}