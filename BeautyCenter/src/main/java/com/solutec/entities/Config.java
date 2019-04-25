package com.solutec.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Config extends Salon {

	@Id @GeneratedValue
	private Long idConfig;
	
	private Salon idSalon;
	private int nbPersonnelTotal;
	private Date HStart;
	private Date HEnd;
	
	
	public Config(Salon idSalon, int nbPersonnelTotal, Date hStart, Date hEnd) {
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
	public Salon getIdSalon() {
		return idSalon;
	}
	public void setIdSalon(Salon idSalon) {
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


	public int getNbPersonnelTotal() {
		return nbPersonnelTotal;
	}


	public void setNbPersonnelTotal(int nbPersonnelTotal) {
		this.nbPersonnelTotal = nbPersonnelTotal;
	}
	

}
