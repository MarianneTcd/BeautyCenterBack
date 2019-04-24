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
	
	
	/*@RequestMapping(value="/events/{id}", method=RequestMethod.GET)
	public Event getEvent(@PathVariable Long id) {
		return eventRepos.findOne(id); 
	}*/
	
	@RequestMapping(value="/events/3", method=RequestMethod.GET)
	public List<Event> PrestaEvent() {
		return eventRepos.findBy(); 
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

	
	@RequestMapping(value="/events/{id}", method=RequestMethod.PUT)
	public Event modifEvent(@PathVariable Long id, @RequestBody Event e) {
		e.setId(id);
		return eventRepos.save(e);
	}
	
	

	
	
}
