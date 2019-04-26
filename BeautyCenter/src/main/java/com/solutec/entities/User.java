package com.solutec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author ESIC
 *
 */
@Entity
public class User {
	@Id @GeneratedValue
	private Long id;
	private String nom;
	private String prenom;
	private String mail;
	private String mdp;
	private Integer access;
	@Column(name="photo")
	private String photo = "https://s1.ibtimes.com/sites/www.ibtimes.com/files/styles/lg/public/2018/01/10/screen-shot-2018-01-10-5.png";
	
	
	public User() {
		super();
	}

	public User(String nom, String prenom, String mail, String mdp, Integer access, String photo) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
		this.access = access;
		this.photo = photo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Integer getAccess() {
		return access;
	}

	public void setAccess(Integer access) {
		this.access = access;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	
}
