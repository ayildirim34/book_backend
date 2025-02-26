package com.ahmyil.buchshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmyil.buchshop.model.Users;


public interface UserRepository extends JpaRepository<Users, Long>{
	
	Optional<Users> findByUserName(String username);
}
