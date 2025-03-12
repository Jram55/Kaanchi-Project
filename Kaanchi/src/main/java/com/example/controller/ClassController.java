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

import com.example.service.ClassService;

@RestController
@RequestMapping("/class")
@CrossOrigin
public class ClassController {

	
	@Autowired
	private ClassService classservice;
	
	@GetMapping
	public List<com.example.entity.Class> getAll(){
		
		return classservice.getallclass();
	}
	
	
//	@PostMapping
//	public ResponseEntity<com.example.entity.Class> save(@RequestBody com.example.entity.Class classes){
//		
//		classservice.saveclass(classes);
//		return new ResponseEntity<>(HttpStatus.CREATED);
//	}
	
	
	@DeleteMapping("/classId")
	public void delete(@PathVariable Long classId) {
		
		classservice.deleteclass(classId);
		
	}
}
