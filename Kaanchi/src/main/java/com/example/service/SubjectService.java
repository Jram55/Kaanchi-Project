package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Subject;
import com.example.repository.SubjectRepository;

@Service
public class SubjectService {

	
	@Autowired
	private SubjectRepository subjectrepo;

	public List<Subject> getallSubjcet() {
	
		return subjectrepo.findAll();
	}

	public Subject saveSubject(Subject subject) {
		return subjectrepo.save(subject);
		
	}

	public void deleteSubject(Long subjectId) {

		subjectrepo.deleteById(subjectId);
		
	}
	
}
