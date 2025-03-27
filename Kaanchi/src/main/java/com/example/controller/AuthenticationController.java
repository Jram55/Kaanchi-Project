package com.example.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Map<String, String>> login(@RequestBody LoginDto request) throws Exception {

		LoginResponseDto response = userService.login(request);
		if (response != null) {

			Map<String, String> responseBody = new HashMap<>();
			responseBody.put("jwt", response.getToken());
			responseBody.put("name", response.getName());

			return ResponseEntity.ok(responseBody);
		}

		// Return an error response if login fails
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
				.body(Collections.singletonMap("error", "UserName or Password wrong"));
	}
}
