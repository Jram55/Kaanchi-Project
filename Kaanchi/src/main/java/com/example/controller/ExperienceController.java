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

import com.example.entity.Experience;
import com.example.service.ExperienceService;

@RestController
@RequestMapping("/experience")
@CrossOrigin
public class ExperienceController {
	
	@Autowired
	private ExperienceService experienceservice;
	
	
	@GetMapping
	public List<Experience> getAll(){
		
		return experienceservice.getallexperience();
	}
	
	@GetMapping("/experienceId")
	public ResponseEntity<Experience> getById(@PathVariable Long experienceId){

	experienceservice.getexperienceById(experienceId);
	return new ResponseEntity<>(HttpStatus.OK);
}
	
	
	@PostMapping
	public ResponseEntity<Experience> save(@RequestBody Experience experience){
		
		experienceservice.saveexperience(experience);
		return new ResponseEntity<Experience>(HttpStatus.CREATED);
	}
	
	@PutMapping("/experiencedId")
	public ResponseEntity<Experience> update(@PathVariable Long experienceId,@RequestBody Experience experience ){
		
		experienceservice.upadteExperienece(experienceId,experience);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@DeleteMapping("/experienceId")
	public void delete(@PathVariable Long experienceId) {
		
		experienceservice.deleteexperience(experienceId);
		
	}
}