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

import com.example.dto.DepartmentCourseDto;
import com.example.dto.Departmentdto;
import com.example.entity.Department;
import com.example.service.DepartmentService;

@RestController
@RequestMapping("/department")
@CrossOrigin
public class DepartmentController {

	
	@Autowired
	private DepartmentService departmentservice;
	
	@GetMapping
	public List<Departmentdto> getall(){
		
		return departmentservice.getalldepartment();
		
	}
	
	@GetMapping("/{departmentId}")
	public Departmentdto getById(@PathVariable Long departmentId) {
		return departmentservice.getDepartmentById(departmentId);
	}
	
	@PostMapping
	public ResponseEntity<Department> save(@RequestBody Department department){
		
		departmentservice.savedepartment(department);
		return new ResponseEntity<>(department,HttpStatus.CREATED);
	}
	
	@PostMapping("/course")
	 public ResponseEntity<Department>departmentcourse(@RequestBody DepartmentCourseDto Dcoursedto){
	    
	    Department department=departmentservice.departmentcourse(Dcoursedto.getDepartmentId(),Dcoursedto.getCourseId());
	    return new ResponseEntity<>(department,HttpStatus.CREATED);
	  }
	
	

	@PutMapping("/{departmentId}")
	public ResponseEntity<?> updatedepartment(@PathVariable long departmentId,@RequestBody Department department) {
		
		try {
			departmentservice.upadateDepartment(departmentId,department);
			return ResponseEntity.accepted().body(department+"Department Successfully Updated");
		}
		catch(Exception e) {
			return ResponseEntity.badRequest().body(department+"Department Not Found");
		}
		
		
	}
	
	
	@DeleteMapping("/{departmentId}")
	public void delete(@PathVariable Long departmentId) {
		
		departmentservice.deletedepartment(departmentId);
	}
}
