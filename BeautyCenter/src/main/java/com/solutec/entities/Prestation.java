package com.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Prestation {

	@Id @GeneratedValue
	private Long idpresta;
	private String titre;
	private int duree;
	private int nbPersonnel;
	
	
	public Prestation() {
		super();
	}

	public Prestation(Long id, String titre, int duree, int nbPersonnel) {
		super();
		this.idpresta = id;
		this.titre = titre;
		this.duree = duree;
		this.nbPersonnel = nbPersonnel;
	}

	public Long getId() {
		return idpresta;
	}

	public void setId(Long id) {
		this.idpresta = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getNbPersonnel() {
		return nbPersonnel;
	}

	public void setNbPersonnel(int nbPersonnel) {
		this.nbPersonnel = nbPersonnel;
	}
	
}
