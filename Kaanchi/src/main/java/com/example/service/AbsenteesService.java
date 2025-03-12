package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Absentees;
import com.example.repository.AbsenteesRepository;

@Service
public class AbsenteesService {
	
	
	@Autowired
	private AbsenteesRepository absentrepo;
	

	public List<Absentees> getAllabstent() {
		
		return absentrepo.findAll();
	}


	public Absentees getAbsentById(Long absenteesId) {
	
		return absentrepo.findById(absenteesId).orElse(null);
	}


	public Absentees updateAbsentById(Absentees absent,Long absenteesId) {
		
		Optional<Absentees>absentees=absentrepo.findById(absenteesId);
		
		if(absentees.isPresent()) {
			Absentees absents=new Absentees();
			absents.setAttendance(absents.getAttendance());
			absents.setStudent(absents.getStudent());
			absents.setRecordId(absents.getRecordId());
			return absentrepo.save(absents);
			
		}
		return absent;
	}


	public Absentees saveabsent(Absentees absent) {
		
		return absentrepo.save(absent);
	}


	public void deleteAbsentees(Long absenteesId) {
		absentrepo.deleteById(absenteesId);
		
	}
	
	
	

}
