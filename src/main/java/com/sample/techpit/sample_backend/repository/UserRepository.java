package com.sample.techpit.sample_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.techpit.sample_backend.model.User;



public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}