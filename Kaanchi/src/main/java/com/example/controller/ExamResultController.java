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

import com.example.entity.ExamResult;
import com.example.service.ExamResultService;


@RestController
@RequestMapping("/examresult")
@CrossOrigin
public class ExamResultController {

	@Autowired
	private ExamResultService examresultservice;
	
	
	@GetMapping
	public List<ExamResult> getall(){
		return examresultservice.getallexam();
	}
	
	
	@PostMapping
	public ResponseEntity<ExamResult> save(@RequestBody ExamResult exam){
		
		examresultservice.saveexamresult(exam);
		return new ResponseEntity<ExamResult>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/examresultId")
	public void delete(@PathVariable Long examresultId) {
		
		examresultservice.deletexam(examresultId);
	}
	
}
