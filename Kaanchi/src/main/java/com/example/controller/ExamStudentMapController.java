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

import com.example.entity.ExamStudentMap;
import com.example.service.ExamStudentMapService;

@RestController
@RequestMapping("/examstudentmap")
@CrossOrigin
public class ExamStudentMapController {

	
	@Autowired
	private ExamStudentMapService examservice;
	
	
	@GetMapping
	public List<ExamStudentMap> getall(){
		return examservice.getallexam();
	}
	
	
	@PostMapping
	public ResponseEntity<ExamStudentMap> save(@RequestBody ExamStudentMap exam){
		
		examservice.saveExamStudentMap(exam);
		return new ResponseEntity<ExamStudentMap>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/examstudentmapId")
	public void delete(@PathVariable Long examstudentmapId) {
		
		examservice.deletexam(examstudentmapId);
	}
}
