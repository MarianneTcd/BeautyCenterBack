package com.solutec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutec.entities.Mail;

public interface MailRepository extends JpaRepository<Mail, Long>{


}