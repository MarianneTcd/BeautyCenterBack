package com.solutec.entities;

import java.sql.Time;
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
	private Long idconfig;
	private Long idsalon; 
	private int nbPersonnelTotal;
	
	private int hstart;
	private int hend;
	
	public Config(Long idsalon, int nbPersonnelTotal, int hstart ,int hend) {
		super();
		
		this.idsalon = idsalon;
		this.hstart = hstart;
		this.hend = hend;
		this.nbPersonnelTotal = nbPersonnelTotal;
	}


	public Config() {
		super();
	}


	public Long getIdconfig() {
		return idconfig;
	}


	public void setIdconfig(Long idconfig) {
		this.idconfig = idconfig;
	}


	public Long getIdsalon() {
		return idsalon;
	}


	public void setIdsalon(Long idsalon) {
		this.idsalon = idsalon;
	}


	public int getNbPersonnelTotal() {
		return nbPersonnelTotal;
	}


	public void setNbPersonnelTotal(int nbPersonnelTotal) {
		this.nbPersonnelTotal = nbPersonnelTotal;
	}


	public int getHstart() {
		return hstart;
	}


	public void setHstart(int hstart) {
		this.hstart = hstart;
	}


	public int getHend() {
		return hend;
	}


	public void setHend(int hend) {
		this.hend = hend;
	}




	

	

}
