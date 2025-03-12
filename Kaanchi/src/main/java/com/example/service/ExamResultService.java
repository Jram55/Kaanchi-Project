package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.ExamResult;
import com.example.repository.ExamResultRepository;

@Service
public class ExamResultService {
	
	@Autowired
	private ExamResultRepository examresultrepo;

	public List<ExamResult> getallexam() {
		
		return examresultrepo.findAll();
	}

	public ExamResult saveexamresult(ExamResult exam) {
		
		return examresultrepo.save(exam);
		
	}

	public void deletexam(Long examresultId) {
		
		examresultrepo.deleteById(examresultId);
		
	}

}
