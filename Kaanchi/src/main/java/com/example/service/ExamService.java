package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Exam;
import com.example.repository.ExamRepository;

@Service
public class ExamService {

	@Autowired
	private ExamRepository examrepo;

	public List<Exam> getallexam() {
		
		return examrepo.findAll();
	}

	public Exam saveexam(Exam exam) {
		
		return examrepo.save(exam);
		
	}

	public void deletexam(Long examId) {
		
		examrepo.deleteById(examId);
		
	}
}
