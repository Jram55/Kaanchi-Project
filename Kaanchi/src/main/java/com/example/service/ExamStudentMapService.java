package com.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.ExamStudentMap;

import com.example.repository.ExamStudentMapRepository;


@Service
public class ExamStudentMapService {

	
	@Autowired
	private ExamStudentMapRepository examstudentrepo;

	public List<ExamStudentMap> getallexam() {
		
		return examstudentrepo.findAll();
	}

	public ExamStudentMap saveExamStudentMap(ExamStudentMap exam) {
		
		return examstudentrepo.save(exam);
		
		
	}

	public void deletexam(Long examstudentmapId) {
		 examstudentrepo.deleteById(examstudentmapId);
		
	}

	
}
