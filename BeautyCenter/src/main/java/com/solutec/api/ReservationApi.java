package com.solutec.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.solutec.dao.ReservationRepository;
import com.solutec.entities.Reservations;

@RestController
@CrossOrigin("*")
public class ReservationApi {

	@Autowired
	private ReservationRepository resRepos;
	
	@RequestMapping(value="/reserv", method = RequestMethod.GET)
	public List<Reservations> getReservation(){
		return resRepos.findAll();
	}
	
	
	//Liste jours restants dans le mois 
	@RequestMapping(value="/testdate/{mois}", method=RequestMethod.GET)
	public List<LocalDate> joursMois(@PathVariable int mois){

		LocalDate date = LocalDate.now();
		ArrayList<LocalDate> list = new ArrayList();
		while (date.getMonthValue() == mois) {
		    date = date.plusDays(1);
		    list.add(date);
		}

		return list;
		  
		}
	
	@RequestMapping(value="/reservations/{idsalon}/{année}/{mois}/{jour}/", method=RequestMethod.GET)
	public List<Reservations> ReservationsJour(@PathVariable Long idsalon, @PathVariable int année, @PathVariable int mois, @PathVariable int jour){
		LocalDateTime d2 = LocalDateTime.of(année,mois,jour,00,00); 
		LocalDateTime d3 = LocalDateTime.of(année,mois,jour+1,00,00);
		
		return resRepos.findReservationsByJour(d2, d3, idsalon);
	}
	
	
	
	@RequestMapping(value="/reserv/{id}", method=RequestMethod.GET) 
	public Reservations getReservation(@PathVariable Long id) { 
		return resRepos.findOne(id); 
		}
	
	@RequestMapping(value="/reserv", method=RequestMethod.POST) 
	public Reservations saveReservation(@RequestBody Reservations s) { 
		return resRepos.save(s); 
		}

	@RequestMapping(value="/reserv/{id}", method=RequestMethod.DELETE) 
	public boolean supReservation(@PathVariable Long id) { 
		resRepos.delete(id);
		return true; 
		}

	@RequestMapping(value="/reserv/{id}", method=RequestMethod.PUT) 
	public Reservations modifConfig(@PathVariable Long id, @RequestBody Reservations s) { 
		s.setId(id); 
		return resRepos.save(s); 
		}

}
