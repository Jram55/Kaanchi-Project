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

import com.example.entity.Day;
import com.example.service.DayService;

@RestController
@RequestMapping("/day")
@CrossOrigin
public class DayController {

	@Autowired
	private DayService dayservice;
	
	
	@GetMapping
	public List<Day> getAll(){
		return dayservice.getalldays();
	}
	
	@PostMapping
	public ResponseEntity<Day> save(@RequestBody Day day){
		
		dayservice.savedays(day);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/dayId")
	public void delete(@PathVariable Long dayId) {
		
		dayservice.deletedays(dayId);
	}
}
