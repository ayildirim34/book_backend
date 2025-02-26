package com.ahmyil.buchshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ahmyil.buchshop.model.Users;
import com.ahmyil.buchshop.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Users createUser(Users user) {
		return userRepository.save(user);
	}
	
	public Optional<Users> getUserById(Long id) {
		return userRepository.findById(id);
	}
	
	public Optional<Users> getUserByUsername(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}

}
