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
	
	
	public List<LocalTime> listeHeures(LocalTime houverture, LocalTime hfermeture){
		  
		LocalTime tps = houverture;  

		ArrayList<LocalTime> listtps = new ArrayList();
		  while (tps.isBefore(hfermeture)) {
		    tps = tps.plusMinutes(30);
		    listtps.add(tps);
		}
		  
		return listtps;
		

		}
	
	@RequestMapping(value="/reservations/{idsalon}/{année}/{mois}/{jour}", method=RequestMethod.GET)
	public List<LocalTime> ReservationsJour(@PathVariable Long idsalon, @PathVariable int année, @PathVariable int mois, @PathVariable int jour){
		LocalDateTime d2 = LocalDateTime.of(année,mois,jour,00,00); 
		LocalDateTime d3 = LocalDateTime.of(année,mois,jour+1,00,00);
		
		
		ArrayList<Reservations> michel = new ArrayList();
		
		michel.addAll(resRepos.findReservationsByJour(d2, d3, idsalon));
		ArrayList<LocalTime> TimeList = new ArrayList() ; 
		
		for (Reservations i : michel) {
			LocalDateTime abcd = i.getHstart();
			LocalTime tempslocal = abcd.toLocalTime();
			
			TimeList.add(tempslocal);
			
		}
		

		ArrayList<LocalTime> listefinale = new ArrayList();
		ArrayList<LocalTime> jeanlouis = new ArrayList();
		ArrayList<LocalTime> jeanmichel = new ArrayList();
		
		jeanlouis.addAll(listeHeures(LocalTime.of(10,00), LocalTime.of(17, 00)));
		
			  
			for (LocalTime i : jeanlouis) { 
			  for (LocalTime j : TimeList) {
				  
			    
			   if ((i.isAfter(j)) && (i.isBefore(j.plusMinutes(30))) || (i.equals(j))) {
			    	jeanlouis.remove(i);
			    	jeanmichel.add(i);
			    }}};
			 return jeanlouis ; 
		
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



/*retireHeures(listehcomplete, listehreservationsjourj) {

ArrayList<LocalTime> listefinale = new ArrayList();
  
for (LocalTime i : listehcomplete) { 
  for (LocalTime j : listehreservationsjourj) {
    
    if i < j && i > j.plusMinutes(30){
    	listefinale.add(i);
    }}};
  	
return listefinale;

}*/


/*listeHeures(LocalTime houverture, LocalTime hfermeture){
  
LocalTime tps = houverture;  

ArrayList<LocalTime> listtps = new ArrayList();
  while (tps < hfermeture) {
    tps = tps.plusMinutes(30);
    listtps.add(tps);
}
  
return listtps;

}
*/
