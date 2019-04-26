package com.solutec.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
	
	@RequestMapping(value="/reserv/user/{iduser}", method = RequestMethod.GET)
	public List<Reservations> getReservation2(@PathVariable Long iduser){
		return resRepos.findReservationsUser(iduser);
	}
	
	
	//Liste jours restants dans le mois 
	@RequestMapping(value="/testdate/{mois}", method=RequestMethod.GET)
	
	
	public List<LocalDate> joursMois(@PathVariable int mois){
		
		LocalDate date = LocalDate.now();
		ArrayList<LocalDate> list = new ArrayList();
		
		int test = mois - date.getMonthValue();
		int newmois = date.getMonthValue() + test;
		
		if (date.getMonthValue() == mois) {
			
			while (date.getMonthValue() == mois) {
				list.add(date);
				date = date.plusDays(1);
			}
		
		} else { 
			
			date = date.withMonth(newmois);
			date = date.withDayOfMonth(1);
			
			while(date.getMonthValue() == newmois) {
				list.add(date);
				date = date.plusDays(1);
			}
			
		}

		return list;
		  
		}
	
	
	public List<LocalTime> listeHeures(LocalTime houverture, LocalTime hfermeture){
		  
		LocalTime tps = houverture;  

		ArrayList<LocalTime> listtps = new ArrayList();
		listtps.add(tps);
		  while (tps.isBefore(hfermeture)) {
		    tps = tps.plusMinutes(30);
		    listtps.add(tps);
		}
		  
		return listtps;
		

		}
	

	@RequestMapping(value="/reservations/sal{idsalon}/presta{idpresta}/{année}/{mois}/{jour}/{hOuv}/{hFerm}", method=RequestMethod.GET)
	public List<LocalTime> ReservationsJour(@PathVariable Long idsalon, @PathVariable Long idpresta, @PathVariable int année, @PathVariable int mois, @PathVariable int jour, @PathVariable int hOuv, @PathVariable int hFerm){
		LocalDateTime d2 = LocalDateTime.of(année,mois,jour,00,00); 
		LocalDateTime d3 = LocalDateTime.of(année,mois,jour+1,00,00);
		
		LocalTime t1 = LocalTime.of(hOuv, 00); 
		LocalTime t2 = LocalTime.of(hFerm, 00); 
		
	    ArrayList<LocalTime> TimeList = new ArrayList() ;
	    ArrayList<Integer> dureesPresta = new ArrayList() ;
	    ArrayList<Reservations> reservations = (ArrayList) resRepos.findReservationsByJour(d2, d3, idsalon, idpresta);
	       
	    for (Reservations r : reservations) {
	        TimeList.add(r.getHstart().toLocalTime());     
	        dureesPresta.add(r.getDureepresta());
	    }  
	 
	    ArrayList<LocalTime> listefinale = new ArrayList();
	 
	    // Mettre 10 et 17 en paramètre de la fonction ou aller les chercher avec une requête SQL
	    ArrayList<LocalTime> heures = (ArrayList) listeHeures(t1, t2);
	    ArrayList<LocalTime> listefinalee = (ArrayList) listeHeures(t1, t2);
	                 
	    for (LocalTime h : heures) {
	        for (LocalTime t : TimeList) {  
	        	int i = TimeList.indexOf(t);
	            if (h.isAfter(t) && h.isBefore(t.plusMinutes(dureesPresta.get(i))) || h.equals(t)) {
	            	System.out.println("bonjour test ZZEIFHZEIFHZEUIPFHZIEPFHZIPFHZIPEHFZEIPFHZIPEFHZEIPFHZEIPFHZEIFHZIEFHZEIPFHZEIPFHZEIPFHZEIPFHZIPEFHZIEFHZIEFHZIPEFHZIPEFHZIPEHFZIPEFHZIPEFHPZIEFHZIPEFHZEIPFHZPEIHFZEIHFZE");
	                listefinalee.remove(h);
	                
	            }
	        }
	    }
	   
	    return listefinalee;    
	}

	
	@RequestMapping(value="/reserv/{id}", method=RequestMethod.GET) 
	public Reservations getReservation(@PathVariable Long id) { 
		return resRepos.findOne(id); 
		}
	
	@RequestMapping(value="/reserv", method=RequestMethod.POST) 
	public Reservations saveReservation(@RequestBody Reservations s) { 
		return resRepos.save(s); 
		}
	
	@RequestMapping(value="/reservs", method=RequestMethod.POST) 
	
	public Reservations saveReservation2(@RequestBody Long idsalon, @RequestBody Long iduser, @RequestBody Long idpresta, @RequestBody int annee, @RequestBody int mois, @RequestBody int jour, @RequestBody int heure, @RequestBody int minute, @RequestBody int dureepresta) { 
		LocalDateTime dt = LocalDateTime.of(annee,mois,jour,heure,minute); 
		return resRepos.save( new Reservations(idsalon, iduser, idpresta, dt , dureepresta)); 
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






