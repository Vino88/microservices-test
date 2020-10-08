package com.microservice.vino.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.vino.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	Optional<User> findByEmail(String email);

	Boolean existsByPhoneNumber(String phoneNumber);

	Boolean existsByEmail(String email);
	
	User findByUserId(String userId);
	
	User findByUsername(String username);
	
	User findByPhoneNumber(String phoneNumber);
	
}
