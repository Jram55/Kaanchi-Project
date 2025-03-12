package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.entity.Users;
import com.example.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {

	
	@Autowired
	private UserService userservice;
	
	
	@PostMapping("/new")
	public Users adduser(@RequestBody Users user) {
		
		return userservice.addUser(user);
	}
	
	@GetMapping
	public List<Users> GetAlluser(){
		return userservice.getAlluser();
	}
	
	
	@PutMapping("/userId")
	public Users upadateuser(@RequestBody Users user,@PathVariable Long userId) {
		return userservice.updateuser(user,userId);
	}
	
	
	@DeleteMapping("/userId")
	public void deleteuser(@PathVariable Long userId) {
		
		userservice.deleteuser(userId);
	}
	
	
	
	}

