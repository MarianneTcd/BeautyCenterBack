package com.solutec.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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


}
