package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.ExamSubjectMap;
import com.example.repository.ExamSubjectmapRepository;

@Service
public class ExamSubjcetMapService {

	@Autowired
	private ExamSubjectmapRepository examsubjectrepo;

	public List<ExamSubjectMap> getallexam() {
		
		return examsubjectrepo.findAll();
	}

	public ExamSubjectMap saveExamSubjectMap(ExamSubjectMap exam) {
		
		return examsubjectrepo.save(exam);
		
	}

	public void deletexam(Long examsubjectmapId) {
		examsubjectrepo.deleteById(examsubjectmapId);
		
	}
	
	
	

   
}
