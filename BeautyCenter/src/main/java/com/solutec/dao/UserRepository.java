package com.solutec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutec.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {


}
