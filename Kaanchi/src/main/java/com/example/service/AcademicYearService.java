package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.AcademicYear;
import com.example.entity.Student;
import com.example.repository.AcademicYearRepository;
import com.example.repository.StudentRepository;

@Service
public class AcademicYearService {

	@Autowired
	private AcademicYearRepository acadamicyearrepo;
	
	@Autowired
	private StudentRepository studentrepo;

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

	public AcademicYear studentAcademmic(long academicyearId, long studentId) {
		
		Student student=studentrepo.findById(studentId).orElseThrow(()
				->new RuntimeException("Student Not found"));
		
		AcademicYear academic=acadamicyearrepo.findById(academicyearId).orElseThrow(()
				-> new RuntimeException("AcademicYear not found"));
		
		academic.setStudent(student);
		
		return acadamicyearrepo.save(academic);

	}

	

}
