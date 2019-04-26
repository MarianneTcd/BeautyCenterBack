package com.solutec.api;

import java.time.LocalDateTime;

import org.apache.naming.factory.SendMailFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.solutec.dao.PresqueReservationsRepository;
import com.solutec.dao.PrestationRepository;
import com.solutec.dao.ReservationRepository;
import com.solutec.dao.SalonRepository;
import com.solutec.dao.UserRepository;
import com.solutec.entities.Mail;
import com.solutec.entities.PresqueReservations;
import com.solutec.entities.Prestation;
import com.solutec.entities.Reservations;
import com.solutec.entities.Salon;
import com.solutec.entities.User;

@RestController
@CrossOrigin("*")
public class PresqueReservationsApi {
	
	@Autowired 
	private PresqueReservationsRepository presqueReservRepos; 
	@Autowired
	private ReservationRepository resRepos;
	
	@Autowired
	private UserRepository UserRepos;
	
	@Autowired
	private SalonRepository SalonRepos;
	
	@Autowired
	private PrestationRepository PrestaRepos;
	
	
	@RequestMapping(value="/PresqueReservations", method=RequestMethod.POST) 
	public Mail savePresqueReservations(@RequestBody PresqueReservations reservation) { 
		
		int annee = reservation.getAnnee();
		int mois = reservation.getMois();
		int jour = reservation.getJour();
		int heure = reservation.getHeure();
		int minute = reservation.getMinute();
		
		
		LocalDateTime dt = LocalDateTime.of(annee,mois,jour,heure,minute);
		
		User u = UserRepos.findOne(reservation.getIduser());
		Salon s = SalonRepos.findOne(reservation.getIdsalon());
		Prestation p = PrestaRepos.findOne(reservation.getIdpresta());
		

		
		resRepos.save( new Reservations(reservation.getIdsalon(), reservation.getIduser(), reservation.getIdpresta(), dt , reservation.getDureepresta())); 
		
		String Newligne=System.getProperty("line.separator");
		
		String emailfooter ="Ce message vous est adressé automatiquement. Nous vous remercions de ne pas répondre, ni d'utiliser cette adresse email."
				+ Newligne + "Afin de ne pas être victime d'une arnaque sur internet, il est conseillé de regarder l'adresse du site dans la barre de navigation. "
				+ Newligne + "ATTENTION : Ce message est strictement confidentiel. Si vous n\'êtes pas destinataire du message, merci de le détruire. ";

		
		String destinataire = u.getMail();
		String objet = "BeautyCenter : Confirmation reservation";
		String contenu = "Bonjour " + u.getPrenom() + " " + u.getNom() + "," 
		+ Newligne + ""
		+ Newligne + "votre reservation pour le salon a bien été prise en compte"
		+ Newligne + ""+ s.getNomSalon()
		+ Newligne + "" + p.getTitre()
		+ Newligne + "" + dt
		+ Newligne + ""
		+ Newligne + "\"Prends soin de toi\"" 
		+ Newligne + "L'équipe BeautyCenter"
		+ Newligne + emailfooter
		+ Newligne ;
		
		Mail mail = new Mail(objet, contenu, destinataire);
		
		
		
	
	

		return mail; 
	
	
	}

}

