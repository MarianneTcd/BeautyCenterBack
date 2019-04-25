package com.solutec.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.solutec.dao.EventRepository;

import com.solutec.entities.Event;



@RestController
@CrossOrigin("*")
public class EventApi {
	
	
	@Autowired
	private EventRepository eventRepos ; 
	
	@RequestMapping(value="/events", method=RequestMethod.GET)
	public List<Event> getEvent() { 
		return eventRepos.findAll(); 
	}
	
	
	/* TEST requête JPQL
	 * 
	 *  
	 *  @RequestMapping(value="/events/{id}", method=RequestMethod.GET)
	public Event getEvent(@PathVariable Long id) {
		return eventRepos.findOne(id); 
	}
	
	@RequestMapping(value="/events/{id}", method=RequestMethod.GET)
	public List<Event> Eventbyid(@PathVariable Long id) {
		return eventRepos.findBy(id); 
	}
	
	@RequestMapping(value="/events/test/{id}", method=RequestMethod.GET)
	public List<Event> EventByIdPresta(@PathVariable Long id) {
		return eventRepos.findByIdPresta(id); 
	}
	
	@RequestMapping(value="/events/test1/{id}", method=RequestMethod.GET)
	public List<Event> EventByIdSalon(@PathVariable Long id) {
		return eventRepos.findByIdSalon(id); 
	}
	
	@RequestMapping(value="/events/test2", method=RequestMethod.GET)
	public List<Event> EventNomSalon() {
		return eventRepos.findNomSalon(); 
	}*/
	
	
	
	// Infos d'une ou des prestations en fonction de l'id du salon --> VOIR EventRepository pour la requête
	@RequestMapping(value="/events/salon/{id}", method=RequestMethod.GET)
	public List<Event> InfosPrestabyIdSalon(@PathVariable Long id) {
		return eventRepos.findInfosPrestaByIdSalon(id); 
	}
	
	
	@RequestMapping(value="/events", method=RequestMethod.POST)
	public Event saveEvent(@RequestBody Event e) {
		return eventRepos.save(e); 
	}
	
	@RequestMapping(value="/events/{id}", method=RequestMethod.DELETE)
	public boolean supEvent(@PathVariable Long id) {
		eventRepos.delete(id);
		return true;
	}
	
	
	// Supprimer un Event à partir de l'id Salon 
	@RequestMapping(value="/events/salon/{id}", method=RequestMethod.DELETE)
	public boolean supEventByIdSalon(@PathVariable Long id) {
		eventRepos.DeleteByIdSalon(id);
		return true;
	}


		@RequestMapping(value="/events/{id}", method=RequestMethod.PUT)
	public Event modifEvent(@PathVariable Long id, @RequestBody Event e) {
		e.setId(id);
		return eventRepos.save(e);
	}
	
	

	
	
}
