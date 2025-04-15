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

import com.example.dto.StaffDepartmentDto;
import com.example.dto.StaffDto;
import com.example.entity.Department;
import com.example.entity.Staff;
import com.example.service.StaffService;

import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("/staff")
@CrossOrigin
public class StaffController {

	
	@Autowired
	private StaffService staffservice;
	
	
	@GetMapping
	public List<StaffDto> getall(){
		
		return staffservice.getall();
	}
	
	@GetMapping("/{staffId}")
	public ResponseEntity<Staff> getById(@PathVariable Long staffId){
		
		Staff staff=staffservice.getstaffById(staffId);
		
		return new ResponseEntity<>(staff,HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<Staff> save(@RequestBody Staff staff){
		
		staffservice.savestaff(staff);
		return new ResponseEntity<>(staff,HttpStatus.CREATED);
	}
	
	@PostMapping("/adddepartment")
	public ResponseEntity<Staff> savestaffdepartment(@RequestBody StaffDepartmentDto Dstaffdto){
		Staff staff=staffservice.savestaffDepartment(Dstaffdto.getDepartmentId(),Dstaffdto.getStaffId());
		return new ResponseEntity<>(staff,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{staffId}")
	public void delete(@PathVariable Long staffId) {
		
		staffservice.deleteservice(staffId);
	}
}
