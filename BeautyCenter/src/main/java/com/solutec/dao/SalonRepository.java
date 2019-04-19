package com.solutec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutec.entities.Salon;

public interface SalonRepository extends JpaRepository<Salon, Long> {

}
