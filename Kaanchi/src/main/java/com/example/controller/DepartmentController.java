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

import com.example.dto.CourseDto;
import com.example.entity.Course;
import com.example.entity.Department;
import com.example.service.DepartmentService;

@RestController
@RequestMapping("/department")
@CrossOrigin
public class DepartmentController {

	
	@Autowired
	private DepartmentService departmentservice;
	
	@GetMapping
	public List<Department> getall(){
		
		return departmentservice.getalldepartment();
		
	}
	
	@GetMapping("/{departmentId}")
	public Department getById(@PathVariable Long departmentId) {
		return departmentservice.getDepartmentById(departmentId);
	}
	
	@PostMapping
	public ResponseEntity<Department> save(@RequestBody Department department){
		
		departmentservice.savedepartment(department);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping("/department/course")
	 public ResponseEntity<Department>departmentcourse(@RequestBody CourseDto coursedto){
	    
	    Department department=departmentservice.departmentcourse(coursedto.getDepartmentId(),coursedto.getCourseId());
	    return new ResponseEntity<>(department,HttpStatus.CREATED);
	  }
	
	@DeleteMapping("/{departmentId}")
	public void delete(@PathVariable Long departmentId) {
		
		departmentservice.deletedepartment(departmentId);
	}
}
