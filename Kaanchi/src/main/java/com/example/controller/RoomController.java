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

import com.example.entity.Room;
import com.example.service.RoomService;

@RestController
@RequestMapping("/room")
@CrossOrigin
public class RoomController {
	
	@Autowired
	private RoomService roomservice;
	
	
	@GetMapping
	public List<Room> getAll(){
		
		return roomservice.getallservice();
	}

	
	@PostMapping
	public ResponseEntity<Room> save(@RequestBody Room room){
		
		roomservice.saveroom(room);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/roomId")
	public void delete(@PathVariable Long roomId) {
		
		roomservice.deleteroom(roomId);
	}
}
