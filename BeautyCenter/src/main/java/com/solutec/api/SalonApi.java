package com.solutec.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.solutec.dao.SalonRepository;
import com.solutec.entities.Salon;



@RestController
@CrossOrigin("*")
public class SalonApi {

@Autowired
private SalonRepository salonRepos ; 

@RequestMapping(value="/salons", method=RequestMethod.GET) 
public List<Salon> getSalon() { 
return salonRepos.findAll(); 	
}

@RequestMapping(value="/salons/{id}", method=RequestMethod.GET) 
public Salon getSalon(@PathVariable Long id) { 
	return salonRepos.findOne(id); 
	}

@RequestMapping(value="/salons/manager/{idManager}", method=RequestMethod.GET)
public List<Salon> ListSalonManager(@PathVariable int idManager) {
	return salonRepos.findSalonsByIdManager(idManager); 
}


@RequestMapping(value="/salons", method=RequestMethod.POST) 
public Salon saveSalon(@RequestBody Salon s) { 
	return salonRepos.save(s); 
	}

@RequestMapping(value="/salons/{id}", method=RequestMethod.DELETE) 
public boolean supSalon(@PathVariable Long id) { 
	salonRepos.delete(id);
	return true; 
	}

@RequestMapping(value="/salons/{id}", method=RequestMethod.PUT) 
public Salon modifSalon(@PathVariable Long id, @RequestBody Salon s) { 
	s.setId(id); 
	return salonRepos.save(s); 
	}

}
