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

import com.example.entity.TimeTableSession;
import com.example.service.TimeTableSessionService;


@RestController
@RequestMapping("/timetablesession")
@CrossOrigin
public class TimeTableSessionController {

	
	@Autowired
   private	TimeTableSessionService timetableservice;
	

	
	
	@GetMapping
	public List<TimeTableSession> getall(){
		return timetableservice.getalltimetablesession();
	}
	
	
	@PostMapping
	public ResponseEntity<TimeTableSession> save(@RequestBody TimeTableSession timetable){
		
		timetableservice.savetimetablesession(timetable);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/timetablesessionId")
	public void delete(@PathVariable Long timetablesessionId) {
		
		timetableservice.deletetimetablesession(timetablesessionId);
	}
	
}
