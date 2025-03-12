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

import com.example.entity.Absentees;
import com.example.service.AbsenteesService;

@RestController
@RequestMapping("/absentees")
@CrossOrigin
public class AbsenteesController {

	
	@Autowired
	private AbsenteesService absentservice;
	
	
	@GetMapping
	public List<Absentees> getAll(){
		
		return absentservice.getAllabstent();
	}
	
	
	@GetMapping("/absenteesId")
	public ResponseEntity<Absentees> getByid(@PathVariable Long absenteesId){
		
		absentservice.getAbsentById(absenteesId);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Absentees> save(@RequestBody Absentees absent){
		
		absentservice.saveabsent(absent);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	@PutMapping("/absenteesId")
	public ResponseEntity<Absentees> updateById(@RequestBody Absentees absent,@PathVariable Long absenteesId){
		absentservice.updateAbsentById(absent,absenteesId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@DeleteMapping("/absenteesId")
	public void delete(@PathVariable Long absenteesId) {
		
		absentservice.deleteAbsentees(absenteesId);
	}
}
