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

import com.example.entity.StaffSubjectMap;
import com.example.service.StaffSubjectMapService;

@RestController
@RequestMapping("/staffsubjcetmap")
@CrossOrigin
public class StaffSubjectMapController {

	@Autowired
	private StaffSubjectMapService staffsubjectservice;
	
	
	@GetMapping
	public List<StaffSubjectMap> getAll(){
		
		return staffsubjectservice.getAllstaffsubject();
	}
	
	@PostMapping
	public ResponseEntity<StaffSubjectMap> save(@RequestBody StaffSubjectMap staffsubject){
		
		staffsubjectservice.savestaffsubject(staffsubject);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/staffsubjectId")
	public void delete(@PathVariable Long staffsubjectId) {
		
		staffsubjectservice.deletestaffsubject(staffsubjectId);
		
	}
}
