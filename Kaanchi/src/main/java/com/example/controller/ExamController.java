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

import com.example.entity.Exam;
import com.example.service.ExamService;

@RestController
@RequestMapping("/exam")
@CrossOrigin
public class ExamController {

	@Autowired
	private ExamService examservice;
	
	
	@GetMapping
	public List<Exam> getall(){
		return examservice.getallexam();
	}
	
	
	@PostMapping
	public ResponseEntity<Exam> save(@RequestBody Exam exam){
		
		examservice.saveexam(exam);
		return new ResponseEntity<Exam>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/examId")
	public void delete(@PathVariable Long examId) {
		
		examservice.deletexam(examId);
	}
}
