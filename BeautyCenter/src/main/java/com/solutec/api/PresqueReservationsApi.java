package com.solutec.api;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.solutec.dao.PresqueReservationsRepository;
import com.solutec.dao.ReservationRepository;
import com.solutec.entities.PresqueReservations;
import com.solutec.entities.Reservations;

@RestController
@CrossOrigin("*")
public class PresqueReservationsApi {
	
	@Autowired 
	private PresqueReservationsRepository presqueReservRepos; 
	@Autowired
	private ReservationRepository resRepos;
	
	@RequestMapping(value="/PresqueReservations", method=RequestMethod.POST) 
	public Reservations savePresqueReservations(@RequestBody PresqueReservations reservation) { 
		
		int annee = reservation.getAnnee();
		int mois = reservation.getMois();
		int jour = reservation.getJour();
		int heure = reservation.getHeure();
		int minute = reservation.getMinute();
		
		
		LocalDateTime dt = LocalDateTime.of(annee,mois,jour,heure,minute);
		
		
		return resRepos.save( new Reservations(reservation.getIdsalon(), reservation.getIduser(), reservation.getIdpresta(), dt , reservation.getDureepresta())); 
		}
	
	
	@RequestMapping(value="/PresqueReservations/{id}", method=RequestMethod.PUT) 
	public Reservations modifPresqueReservations(@PathVariable Long id, @RequestBody PresqueReservations reservation) { 
		
		int annee = reservation.getAnnee();
		int mois = reservation.getMois();
		int jour = reservation.getJour();
		int heure = reservation.getHeure();
		int minute = reservation.getMinute();
		
		
		LocalDateTime dt = LocalDateTime.of(annee,mois,jour,heure,minute);
		
		Reservations r = new Reservations() ; 
		r.setId(id);
		r.setHstart(dt);
		return resRepos.save(r);
		}

}

