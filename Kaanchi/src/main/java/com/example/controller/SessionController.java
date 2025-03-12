package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Session;
import com.example.service.SessionService;

@RestController
@RequestMapping("/session")
@CrossOrigin
public class SessionController {
	
	@Autowired
	private SessionService sessionservice;
	
	
	
	@GetMapping
	public List<Session> getAll(){
		
		return sessionservice.getAllsession();
	}
	
	
	@PostMapping
	public ResponseEntity<Session> save(@RequestBody Session session){
		
		sessionservice.savesession(session);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	
	@PutMapping("/sessionId")
	public ResponseEntity<Session> update(@PathVariable Long sessionId,@RequestBody Session session){
		
		
		sessionservice.updatesession(sessionId,session);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@DeleteMapping("/sessionId")
	public void delete(@PathVariable Long sessionId) {
		
		sessionservice.deletesession(sessionId);
	}
	
	
	
}
