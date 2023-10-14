package com.university.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.auth.model.User;

@Repository
public interface AuthRepository extends JpaRepository<User, Integer>{
	
	boolean existsByUserName(String userName);
	
	boolean existsByEmailId(String emailId);
	
	Optional<User> findByUserName(String userName);
}
