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


import com.example.entity.AcademicHistory;
import com.example.service.AcademicHistoryService;


@RestController
@RequestMapping("/acadamichistory")
@CrossOrigin
public class AcadamicHistoryController {

	
	@Autowired
	private AcademicHistoryService acadamicservice;
	
	
	@GetMapping
	public List<AcademicHistory> getAll(){
		return acadamicservice.getAcadamichistory();
	}
	
	
	@PostMapping
	public ResponseEntity<AcademicHistory> save(@RequestBody AcademicHistory acadamic){
		
	acadamicservice.saveacadamchistory(acadamic);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/academicId")
	public void delete(@PathVariable Long academicId){
		
		acadamicservice.deleteacadamic(academicId);
		
	}
}
