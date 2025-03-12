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

import com.example.entity.Attendance;
import com.example.service.AttendanceService;

@RestController
@RequestMapping("/attednance")
@CrossOrigin
public class AttendanceController {

	
	@Autowired
	private AttendanceService attendanceservice;
	
	
	
	@GetMapping
	public List<Attendance> getAll(){
		
		return attendanceservice.getallattendance();
		
	}
	
	
	@PostMapping
	public ResponseEntity<Attendance> save(@RequestBody Attendance attend){
		
		attendanceservice.saveattendance(attend);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/attendanceId")
	public void delete(@PathVariable Long attendanceId) {
		
		attendanceservice.deleteattendance(attendanceId);
		
	}
}
