package com.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Event {
	
	@Id @GeneratedValue
	private Long id; 
	
	@ManyToOne
	private Salon salon; 
	
	@ManyToOne
	private Prestation presta;
	
	
	public Event(Long id, Salon salon, Prestation presta) {
		super();
		this.id = id;
		this.salon = salon;
		this.presta = presta;
	}
	
	
	public Event(Salon salon, Prestation presta) {
		super();
		this.salon = salon;
		this.presta = presta;
	}


	public Event() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Salon getSalon() {
		return salon;
	}
	public void setSalon(Salon salon) {
		this.salon = salon;
	}
	public Prestation getPresta() {
		return presta;
	}
	public void setPresta(Prestation presta) {
		this.presta = presta;
	} 
	
	

}