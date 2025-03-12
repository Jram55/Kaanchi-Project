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

import com.example.entity.TimeTable;
import com.example.service.TimeTableService;


@RestController
@RequestMapping("/timetable")
@CrossOrigin
public class TimeTableController {

	@Autowired
	private TimeTableService timetableservice;
	
	
	
	
	@GetMapping
	public List<TimeTable> getall(){
		return timetableservice.getalltimetable();
	}
	
	
	@PostMapping
	public ResponseEntity<TimeTable> save(@RequestBody TimeTable timetable){
		
		timetableservice.savetimetable(timetable);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/timetableId")
	public void delete(@PathVariable Long timetableId) {
		
		timetableservice.delettimetable(timetableId);
	}
}
