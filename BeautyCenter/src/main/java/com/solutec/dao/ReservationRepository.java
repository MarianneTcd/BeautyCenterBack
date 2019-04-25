package com.solutec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutec.entities.Reservations;

public interface ReservationRepository extends JpaRepository<Reservations, Long> {

}
