package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Room;
import com.example.repository.RoomRepository;

@Service
public class RoomService {
	
	@Autowired
	private RoomRepository roomrepo;

	public List<Room> getallservice() {
	
		return roomrepo.findAll();
	}

	public Room saveroom(Room room) {
		
		return roomrepo.save(room);
		
	}

	public void deleteroom(Long roomId) {

       roomrepo.deleteById(roomId);
		
	}
	
	
	

}
