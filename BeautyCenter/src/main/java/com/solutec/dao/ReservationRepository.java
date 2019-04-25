package com.solutec.dao;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.solutec.entities.Reservations;

public interface ReservationRepository extends JpaRepository<Reservations, Long>  {

	
	@Query("select r from Reservations r where r.hstart >= :startDate AND r.hstart < :endDate AND r.idsalon =:idsalon")
      public List<Reservations> findReservationsByJour(@Param("startDate") LocalDateTime date1, @Param("endDate") LocalDateTime date2, @Param("idsalon") Long idsalon) ;
	
	
	
}
