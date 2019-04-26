package com.solutec.dao;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.solutec.entities.Config;


public interface ConfigRepository extends JpaRepository<Config, Long> {
	
	@Query("SELECT c.hstart FROM Config c WHERE c.idsalon = ?1") 
	public int findHstart(Long idsalon) ; 

	@Query("SELECT c.hend FROM Config c WHERE c.idsalon = ?1") 
	public int findHEnd(Long idsalon) ; 

}
