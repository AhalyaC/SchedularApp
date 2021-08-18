package com.scheduler.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scheduler.springboot.model.User;

public interface UserDAO extends JpaRepository<User, Integer> {

	
}
