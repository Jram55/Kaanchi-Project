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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Semester;
import com.example.service.SemesterService;

@RestController
@RequestMapping("/semester")
@CrossOrigin
public class SemesterController {

	
	@Autowired
	private SemesterService semesterservice;
	
	
	@GetMapping
	public List<Semester> getall(){
		
		return semesterservice.getall();
	}
	
	
	@PostMapping
	public ResponseEntity<Semester> save(@RequestBody Semester sem){
		
		semesterservice.savesemester(sem);
		return new ResponseEntity<>(HttpStatus.CREATED);
				
	}
	
	
	@DeleteMapping("/semesterId")
	public void delete(@PathVariable Long semesterId) {
		
		semesterservice.deletesemester(semesterId);
	}
}
