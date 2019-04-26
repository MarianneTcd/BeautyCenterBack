package com.solutec.api;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.solutec.dao.MailRepository;
import com.solutec.dao.PrestationRepository;
import com.solutec.dao.SalonRepository;
import com.solutec.dao.UserRepository;
import com.solutec.entities.Mail;
import com.solutec.entities.Prestation;
import com.solutec.entities.Reservations;
import com.solutec.entities.Salon;
import com.solutec.entities.User;

@RestController
@CrossOrigin("*")
public class MailApi {
	
	@Autowired
	private MailRepository mailRepos;
	
	@Autowired
	private UserRepository userRepos;
	
	@Autowired
	private SalonRepository salonRepos;
	
	@Autowired
	private PrestationRepository prestaRepos;
	
	private void sendMail(String destinataire, String objet, String contenu) {
		/*final String expediteur = "jp@joelbpro.com";
		final String password = "Azerty2019";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "ssl0.ovh.net");
		props.put("mail.smtp.port", "587");*/
		
		
		/*l'expéditeur est un mail créé au préalable sur gmail*/
		final String expediteur = "beautycenter570@gmail.com";
		final String password = "solutec12";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(expediteur, password);
					}
				  });
		
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(expediteur));
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(destinataire));
			message.setSubject(objet);
			message.setText(contenu);

			Transport.send(message);

			System.out.println("Mail envoyé");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	/*
	@RequestMapping(value="/mailcreation", method=RequestMethod.POST)
	public Mail mailCreation(@RequestBody Evenement e){
		
		String destinataire = e.getCreateur().getMail();
		String objet = "Création d'un événement sportif";
		String Newligne=System.getProperty("line.separator");
		String contenu = "Bonjour " + e.getCreateur().getPrenom() + " " + e.getCreateur().getNom() + "," 
		+ Newligne + Newligne + "Tu viens de créer un événement de " + e.getSport().getNom() + " le " + e.getDateEvent() + " à " + e.getHoraire() + ". "
		+ Newligne + "Sport2Go te souhaite de trouver des partenaires au plus vite. "  
		+ Newligne + "Tu peux consulter tous tes prochains événements sur : http://localhost:4200/. "
		+ Newligne + Newligne + "A bientôt sur Sport2Go !" 
		+ Newligne + "L'équipe Sport2Go";
		
		Mail mail = new Mail(objet, contenu, destinataire);
		
		sendMail(destinataire, objet, contenu);
		
		return mail;
	}
	
	@RequestMapping(value="/mailconfirmationparticipants", method=RequestMethod.POST)
	public void mailConfirmationParticipants(@RequestBody List<User> participants){
		String objet = "Validation d'un événement auquel vous participez";
		String Newligne=System.getProperty("line.separator");
		for (User user : participants) {
			String destinataire = user.getMail();
			String contenu = "Bonjour " + user.getPrenom() + " " + user.getNom() + "," 
			+ Newligne + Newligne + "Un événement auquel tu t'es inscrit(e) est complet et aura donc bien lieu. "
			+ Newligne + "Tu peux maintenant prendre contact avec le créateur de l'événement pour fixer le lieu de la rencontre. " 
			+ Newligne + "Tu peux consulter tous tes prochains événements sur : http://localhost:4200/. " 
			+ Newligne + Newligne + "A bientôt sur Sport2Go !" 
			+ Newligne + "L'équipe Sport2Go";
			
			sendMail(destinataire, objet, contenu);
		}
	}
	
	@RequestMapping(value="/mailconfirmationreateur", method=RequestMethod.POST)
	public Mail mailConfirmationCreateur(@RequestBody Evenement e){
		String destinataire = e.getCreateur().getMail();
		String objet = "Validation d'un événement que vous avez créé";
		String Newligne=System.getProperty("line.separator");
		String contenu = "Bonjour " + e.getCreateur().getPrenom() + " " + e.getCreateur().getNom() + "," 
		+ Newligne + Newligne + "Ton événement de " + e.getSport().getNom() + " du " + e.getDateEvent() + " à " + e.getHoraire() + " est complet. "
		+ Newligne + "Félicitations ! Tu peux maintenant contacter les participants pour fixer le lieu de la rencontre. "  
		+ Newligne + "Tu peux consulter tous tes prochains événements sur : http://localhost:4200/. "
		+ Newligne + Newligne + "A bientôt sur Sport2Go !" 
		+ Newligne + "L'équipe Sport2Go";
		
		Mail mail = new Mail(objet, contenu, destinataire);
		
		sendMail(destinataire, objet, contenu);
		
		return mail;
	}*/
	
	@RequestMapping(value="/mailcreationcompte", method=RequestMethod.POST)
	public Mail mailCreationCompte(@RequestBody User u){
		String destinataire = u.getMail();
		String objet = "Confirmation de création de compte";
		String Newligne=System.getProperty("line.separator");
		String contenu = "Bonjour " + u.getPrenom() + " " + u.getNom() + "," 
		+ Newligne + Newligne + "Bienvenue sur BeautyCenter ! "
		+ Newligne + "Nous te remercions de l'intérêt que tu portes à notre application."  
		+ Newligne + "Grâce à elle, tu seras au courant des dernières actualités sur les salons de cosmétiques."
		+ Newligne + "Tu pourras sélectionner le salon qui te convient et réserver un créneau en fonction des prestations proposées et des horaires disponibles."
		+ Newligne + ""
		+ Newligne + ""
		+ Newligne + ""
		+ Newligne + "Reste à l'affût, et surtout, prend soin de toi !"
		+ Newligne + ""
		+ Newligne + ""
		+ Newligne + ""
		+ Newligne + "Retrouve-nous sur http://localhost:4200/listesalons " 
		+ Newligne + "L'équipe BeautyCenter"
		+ Newligne + ""
		+ Newligne + emailfooter;
		
		Mail mail = new Mail(objet, contenu, destinataire);
		
		sendMail(destinataire, objet, contenu);
		
		return mail;
	}
	
	
	@RequestMapping(value="/mailcreationmanager", method=RequestMethod.POST)
	public Mail mailCreationManager(@RequestBody User u){
		String destinataire = u.getMail();
		String objet = "BeautyCenter : Confirmation de création de compte manager";
		String Newligne=System.getProperty("line.separator");
		String contenu = "Bonjour " + u.getPrenom() + " " + u.getNom() + "," 
		+ Newligne + Newligne + "Bienvenue sur BeautyCenter ! "
		+ Newligne + "l'administrateur de BeautyCenter vous a créé un compte manager sur BeautyCenter."  
		+ Newligne + "Vous pourrez ainsi créer des salons, les gérer, associer les prestrations prévues et le personnel."
		+ Newligne + ""
		+ Newligne + "Vous trouverez ci-joint les identifiants pour vous connecter en tant que manager."
		+ Newligne + "mail :"+u.getMail() + " , mot de passe : " + u.getMdp() + " ."
		+ Newligne + ""
		+ Newligne + "Une fois connecté nous vous invitons à aller sur votre espace manager, à changer votre mot de passe et à supprimer ce mail."
		+ Newligne + ""
		+ Newligne + "Nous vous souhaitons une bonne aventure sur notre application."
		+ Newligne + "" 
		+ Newligne + "\"Prends soin de toi\"" 
		+ Newligne + "L'équipe BeautyCenter"
		+ Newligne + ""
		+ Newligne + emailfooter;
		
		Mail mail = new Mail(objet, contenu, destinataire);
		
		sendMail(destinataire, objet, contenu);
		
		return mail;
	}
	

		
	@RequestMapping(value="/mailreservation/{iduser}/{idsalon}/{idpresta}", method=RequestMethod.POST)
	public Mail mailReservation(@PathVariable Long iduser, @PathVariable Long idsalon,@PathVariable Long idpresta){
		User u = userRepos.findOne(iduser);
		Salon s = salonRepos.findOne(idsalon);
		Prestation p = prestaRepos.findOne(idpresta);
		String destinataire = u.getMail();
		String objet = "BeautyCenter : Confirmation reservation";
		String Newligne=System.getProperty("line.separator");
		String contenu = "Bonjour " + u.getPrenom() + " " + u.getNom() + "," 
		+ Newligne + ""
		+ Newligne + "votre reservation pour le salon a bien été prise en compte"
		+ Newligne + ""+ s.getNomSalon()
		+ Newligne + ""
		+ Newligne + ""
		+ Newligne + ""
		+ Newligne + "\"Prends soin de toi\"" 
		+ Newligne + "L'équipe BeautyCenter"
		+ Newligne + ""
		+ Newligne + emailfooter;
		
		Mail mail = new Mail(objet, contenu, destinataire);
		
		sendMail(destinataire, objet, contenu);
		
		return mail;
	}
	
	String Newligne=System.getProperty("line.separator");
	
	String emailfooter ="Ce message vous est adressé automatiquement. Nous vous remercions de ne pas répondre, ni d'utiliser cette adresse email."
	+ Newligne + "Afin de ne pas être victime d'une arnaque sur internet, il est conseillé de regarder l'adresse du site dans la barre de navigation. "
	+ Newligne + "ATTENTION : Ce message est strictement confidentiel. Si vous n\'êtes pas destinataire du message, merci de le détruire. ";


}
