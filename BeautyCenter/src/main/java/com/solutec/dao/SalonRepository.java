package com.solutec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.solutec.entities.Salon;

public interface SalonRepository extends JpaRepository<Salon, Long> {
	
	@Query("SELECT s FROM Salon s WHERE s.idManager = ?1")
	public List<Salon> findSalonsByIdManager(int idManager) ;
}
