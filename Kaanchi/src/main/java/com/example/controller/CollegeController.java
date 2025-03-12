package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.College;
import com.example.service.CollegeService;

@RestController
@RequestMapping("/college")
@CrossOrigin
public class CollegeController {
	
	@Autowired
	private CollegeService collegeservice;
	
	
	@GetMapping
	public List<College> getAllcollege(){
		
		return collegeservice.getallcollge();
	}
	
	
	@PostMapping
	public College savecollege(@RequestBody College coll) {
		
		return collegeservice.savecollege(coll);
	}
	
	
	@PutMapping("/collegeId")
	public College updatecollege(@PathVariable long collegeId,@RequestBody College coll) {
		
		return collegeservice.updatecollege(collegeId,coll);
	}
	
	@DeleteMapping("/collegeId")
	public void deletecollege(@PathVariable long collegeId) {
		collegeservice.deletecollege(collegeId);
	}

}
