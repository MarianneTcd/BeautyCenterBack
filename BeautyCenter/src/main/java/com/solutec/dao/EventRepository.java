package com.solutec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.solutec.entities.Event;


public interface EventRepository extends JpaRepository<Event, Long>{
	
	
	@Query("SELECT e FROM Event e WHERE e.id = 3")
	public List<Event> findBy() ; 
	

}