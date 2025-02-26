package com.ahmyil.buchshop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahmyil.buchshop.model.Users;
import com.ahmyil.buchshop.service.UserService;

@Controller
@RequestMapping ("/api/user")

public class UserController{
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<Users> createUser(@RequestBody Users user) {
		return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Users>> getAllUsers(){
		return new ResponseEntity(userService.getAllUsers(), HttpStatus.OK);
	}
}
