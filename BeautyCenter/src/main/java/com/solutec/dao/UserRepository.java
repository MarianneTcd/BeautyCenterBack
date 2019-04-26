package com.solutec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.solutec.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	// Charger la liste de tous les managers
	@Query("SELECT u FROM User u WHERE u.access = 3 OR u.access = 5")
	public List<User> getManagers();


}
