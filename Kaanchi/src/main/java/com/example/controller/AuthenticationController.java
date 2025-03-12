package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginDto;
import com.example.dto.LoginResponseDto;
import com.example.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthenticationController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public String login(@RequestBody LoginDto request)throws Exception {
		

		if (userService.login(request)) {
			LoginResponseDto response = userService.getLoginData(request);
			return response.getToken() ;
		} else {
			return "Error";
		}
		
	}

}
