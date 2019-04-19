package com.solutec.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.solutec.entities.Prestation;

public interface PrestationRepository extends JpaRepository<Prestation, Long>{

}
