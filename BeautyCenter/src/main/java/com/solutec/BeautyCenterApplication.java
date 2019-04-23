package com.solutec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.solutec.dao.SalonRepository;
import com.solutec.entities.Salon;

@SpringBootApplication
public class BeautyCenterApplication implements CommandLineRunner {
	
	@Autowired
	private SalonRepository salonRepos ; 

	public static void main(String[] args) {
		SpringApplication.run(BeautyCenterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		 /*DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		salonRepos.save(new Salon("Salon des Fougères", d.parse("14/05/2019"), "fougère@salon.paris", "2 Rue des Fougères", "01.02.03.04.05"));
		salonRepos.save(new Salon("Salon du PSG", d.parse("25/06/2019"), "psg@salon.paris", "2 Rue du PSG", "01.02.03.04.05"));
		salonRepos.save(new Salon("Salon de Monoprix", d.parse("04/17/2019"), "monoprix@salon.paris", "2 Rue du Monoprix", "01.02.03.04.05")); */

	}

}
