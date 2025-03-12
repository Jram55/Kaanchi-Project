package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Attendance;
import com.example.repository.AttendanceRepository;

@Service
public class AttendanceService {

	
	@Autowired
	private AttendanceRepository attendancerepo;

	public List<Attendance> getallattendance() {
		
		return attendancerepo.findAll();
	}

	public Attendance saveattendance(Attendance attend) {
	
		return attendancerepo.save(attend);
		
	}

	public void deleteattendance(Long attendanceId) {
		
		attendancerepo.deleteById(attendanceId);
		
	}
	
	
	
	
	
	
}
