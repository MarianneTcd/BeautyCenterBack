package com.solutec.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.solutec.dao.PrestationRepository;
import com.solutec.entities.Prestation;

@RestController
@CrossOrigin("*") 
public class PrestationApi {
	
	@Autowired
	private PrestationRepository prestaRepos;
	
	@RequestMapping(value="/prestations", method=RequestMethod.GET)
	public List<Prestation> getAllPresta(){
		return prestaRepos.findAll();
	}
	
	@RequestMapping(value="/prestations/{id}", method=RequestMethod.GET)
	public Prestation getPresta(@PathVariable Long id) {
		return prestaRepos.findOne(id);
	}
	
	@RequestMapping(value="/prestations", method=RequestMethod.POST)
	public Prestation savePresta(@RequestBody Prestation p) {
		return prestaRepos.save(p);
	}
	
	@RequestMapping(value="/prestations/{id}", method=RequestMethod.DELETE)
	public boolean deletPresta(@PathVariable  Long id) {
		prestaRepos.delete(id);
		return true;
	}
	
	@RequestMapping(value="/prestations/{id}", method=RequestMethod.PUT)
	public Prestation modifPresta(@PathVariable Long id, @RequestBody Prestation p) {
		p.setId(id);
		return prestaRepos.save(p);
	}

}
