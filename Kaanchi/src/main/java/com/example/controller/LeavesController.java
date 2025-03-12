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

import com.example.entity.Leaves;
import com.example.service.LeavesService;

@RestController
@RequestMapping("/leave")
@CrossOrigin
public class LeavesController {

	
	@Autowired
	private LeavesService leaveservice;
	

	
	@GetMapping
	public List<Leaves> getall(){
		return leaveservice.getallleaves();
	}
	
	
	@PostMapping
	public ResponseEntity<Leaves> save(@RequestBody Leaves leave){
		
		leaveservice.saveleave(leave);
		return new ResponseEntity<Leaves>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/leaveId")
	public void delete(@PathVariable Long leaveId) {
		
		leaveservice.deletleave(leaveId);
	}
}
