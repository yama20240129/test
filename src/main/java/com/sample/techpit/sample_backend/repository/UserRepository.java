package com.sample.techpit.sample_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}