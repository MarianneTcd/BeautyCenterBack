package com.solutec.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PresqueReservations {
	@Id @GeneratedValue
	private Long idreserv;
	
	private Long idsalon;
	private Long iduser;
	private Long idpresta;
	private int annee; 
	private int mois; 
	private int jour; 
	private int heure; 
	private int minute; 
	private int dureepresta;
	
	public PresqueReservations() {
		super();
	}

	public PresqueReservations(Long idsalon, Long iduser, Long idpresta, int annee, int mois, int jour, int heure,
			int minute, int dureepresta) {
		super();
		this.idsalon = idsalon;
		this.iduser = iduser;
		this.idpresta = idpresta;
		this.annee = annee;
		this.mois = mois;
		this.jour = jour;
		this.heure = heure;
		this.minute = minute;
		this.dureepresta = dureepresta;
	}

	public Long getIdreserv() {
		return idreserv;
	}

	public void setIdreserv(Long idreserv) {
		this.idreserv = idreserv;
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

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getJour() {
		return jour;
	}

	public void setJour(int jour) {
		this.jour = jour;
	}

	public int getHeure() {
		return heure;
	}

	public void setHeure(int heure) {
		this.heure = heure;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getDureepresta() {
		return dureepresta;
	}

	public void setDureepresta(int dureepresta) {
		this.dureepresta = dureepresta;
	}
	
	

}
