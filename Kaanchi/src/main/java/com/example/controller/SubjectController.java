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

import com.example.dto.SubjectCourseDto;
import com.example.entity.Subject;
import com.example.service.SubjectService;

@RestController
@RequestMapping("/subject")
@CrossOrigin
public class SubjectController {

	
	@Autowired
	private SubjectService subjectservice;
	
	
	@GetMapping
	public List<Subject> getall(){
		
		return subjectservice.getallSubjcet();
	}
	
	@GetMapping("/{subjectId}")
	public ResponseEntity<?> getById(@PathVariable long subjectId){
		
		try {
			Subject sub= subjectservice.getSubjectById(subjectId);
			return ResponseEntity.ok().body(sub);
		}
		catch(Exception e){
			
			return ResponseEntity.badRequest().body("not Found");
		}
	}
	
	
	@PostMapping
	public ResponseEntity<Subject> save(@RequestBody Subject subject){
		
		subjectservice.saveSubject(subject);
		return new ResponseEntity<>(subject,HttpStatus.CREATED);
	}
	
	@PostMapping("/addcourse")
	public ResponseEntity<Subject> addsubjectTocourse(@RequestBody SubjectCourseDto subcourse){
		
		subjectservice.addSubjectToCourse(subcourse.getSubjectId(),subcourse.getCourseId());
		return new ResponseEntity(subjectservice,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{subjectId}")
	public void delete(@PathVariable Long subjectId) {
		
		subjectservice.deleteSubject(subjectId);
	}
}
