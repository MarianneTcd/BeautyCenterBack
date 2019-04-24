package com.solutec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutec.entities.Config;

public interface ConfigRepository extends JpaRepository<Config, Long> {

}
