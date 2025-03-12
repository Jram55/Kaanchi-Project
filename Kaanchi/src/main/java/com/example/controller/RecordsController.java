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

import com.example.entity.Records;
import com.example.service.RecordsService;

@RestController
@RequestMapping("/record")
@CrossOrigin
public class RecordsController {

	
	@Autowired
	private RecordsService recordsservice;
	
	
	
	@GetMapping
	public List<Records> getall(){
		
		return recordsservice.getallrecords();
	}
	
	@GetMapping("/recordId")
	public ResponseEntity<Records> getById(@PathVariable long recordId){
		
		recordsservice.getrecordById(recordId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Records> save(@RequestBody Records records){
		
		recordsservice.saverecord(records);
		return new ResponseEntity<Records>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/recordId")
	public void delete(@PathVariable long recordId) {
		
		recordsservice.deleterecord(recordId);
	}
	
}
