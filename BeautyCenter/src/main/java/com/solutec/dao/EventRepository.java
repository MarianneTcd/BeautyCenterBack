package com.solutec.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.solutec.entities.Event;


public interface EventRepository extends JpaRepository<Event, Long>{
	
	// Trouver un Event avec son id 
	@Query("SELECT e FROM Event e WHERE e.id = ?1") 
	public List<Event> findBy(Long id) ; 
	
	//Trouver un Event avec l'id d'une prestation 
	@Query("SELECT e FROM Event e INNER JOIN e.presta p WHERE p.id = ?1") 
	public List<Event> findByIdPresta(Long id) ; 
	
	//Trouver un Event avec l'id d'un salon
	@Query("SELECT e FROM Event e INNER JOIN e.salon s WHERE s.id = ?1")  
	public List<Event> findByIdSalon(Long id) ; 
	
	
	// selectionner seulement le nom du salon des évenements
	@Query("SELECT e.salon.nomSalon FROM Event e")   
	public List<Event> findNomSalon() ; 
	
	
	//trouver les infos de la prestation en fonction de l'id du salon
	@Query("SELECT e.presta FROM Event e INNER JOIN e.salon s WHERE s.id = ?1")  
	public List<Event> findInfosPrestaByIdSalon(Long id) ;
	
	@Query("SELECT e.presta FROM Event e WHERE e.salon.id = ?1") 
	public List<Event> findInfosPrestaByIdSalon2(Long id) ;
	
	
	// Supprimer un Event à partir de l'id salon 	
	@Modifying @Transactional
	@Query("DELETE from Event e WHERE e.salon.id = ?1")  
	void DeleteByIdSalon(Long id) ; 
}



	