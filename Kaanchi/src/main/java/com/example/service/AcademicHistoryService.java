package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.entity.AcademicHistory;

import com.example.repository.AcademicHistoryRepository;

@Service
public class AcademicHistoryService {

	
	@Autowired
	private AcademicHistoryRepository acadamicrepo;

	
	public List<AcademicHistory> getAcadamichistory() {
		
		return acadamicrepo.findAll();
	}


	public AcademicHistory saveacadamchistory(AcademicHistory acadamic) {
		
		return acadamicrepo.save(acadamic);
	}


	public void deleteacadamic(Long academicId) {
		
		 acadamicrepo.deleteById(academicId);
	}
	
}
