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

import com.example.entity.ExamSubjectMap;
import com.example.service.ExamSubjcetMapService;

@RestController
@RequestMapping("/examsubjectMap")
@CrossOrigin
public class ExamSubjectMapController {
	
	
	@Autowired
	private ExamSubjcetMapService examservice;
	
	
	@GetMapping
	public List<ExamSubjectMap> getall(){
		return examservice.getallexam();
	}
	
	
	@PostMapping
	public ResponseEntity<ExamSubjectMap> save(@RequestBody ExamSubjectMap exam){
		
		examservice.saveExamSubjectMap(exam);
		return new ResponseEntity<ExamSubjectMap>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/examsubjectmapId")
	public void delete(@PathVariable Long examsubjectmapId) {
		
		examservice.deletexam(examsubjectmapId);
	}

}
