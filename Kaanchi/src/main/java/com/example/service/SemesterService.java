package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Semester;
import com.example.repository.SemesterRepository;

@Service
public class SemesterService {
	
	@Autowired
	private SemesterRepository semesterrepo;

	public List<Semester> getall() {
		
		return semesterrepo.findAll();
	}

	public Semester savesemester(Semester sem) {
		
		return semesterrepo.save(sem);
		
	}

	public void deletesemester(Long semesterId) {
	
		semesterrepo.deleteById(semesterId);
		
	}
	
	

}
