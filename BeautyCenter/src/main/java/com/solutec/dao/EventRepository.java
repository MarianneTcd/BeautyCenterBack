package com.solutec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutec.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}