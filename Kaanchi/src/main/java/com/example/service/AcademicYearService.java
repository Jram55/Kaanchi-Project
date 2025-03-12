package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.entity.AcademicYear;

import com.example.repository.AcademicYearRepository;



@Service
public class AcademicYearService {
	
	@Autowired
	private AcademicYearRepository acadamicyearrepo;

	public List<AcademicYear> getAllacdamicyear() {
		
		return acadamicyearrepo.findAll();
	}

	public Optional<AcademicYear> GetacadenicyearById(Long academicyearId) {
		
		return acadamicyearrepo.findById(academicyearId).or(null);
	}

	public AcademicYear saveacademicyear(AcademicYear academic) {
		
		return acadamicyearrepo.save(academic);
	}

	public void deleteacadamicyear(Long academicyearId) {
		acadamicyearrepo.deleteById(academicyearId);
		
	}

	
}
