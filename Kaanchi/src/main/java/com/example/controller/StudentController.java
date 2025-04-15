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

import com.example.dto.StudentDto;
import com.example.entity.Student;
import com.example.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

	@Autowired
	private StudentService studentservice;
	
	
	@GetMapping
	public List<StudentDto> getAll(){
		return studentservice.getallstudent();
	}
	
	
	@GetMapping("/{studentId}")
	public ResponseEntity<Student> getById(@PathVariable Long studentId){
		
		Student stu=studentservice.getstudentById(studentId);
		return new ResponseEntity<>(stu,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Student> save(@RequestBody Student student){
		
		Student stu=studentservice.savestudent(student);
		return new ResponseEntity<>(stu,HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Student> upadte(@PathVariable Long studentId,@RequestBody Student student){
		studentservice.updatestudent(studentId,student);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{studentId}")
	public void delete(@PathVariable Long studentId) {
		
		studentservice.deletestudent(studentId);
	}
	
}
