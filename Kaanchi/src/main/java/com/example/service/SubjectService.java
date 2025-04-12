package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Course;
import com.example.entity.Subject;
import com.example.repository.CourseRepository;
import com.example.repository.SubjectRepository;

@Service
public class SubjectService {

	
	@Autowired
	private SubjectRepository subjectrepo;
	
	@Autowired
	private CourseRepository courserepo;

	public List<Subject> getallSubjcet() {
	
		return subjectrepo.findAll();
	}

	public Subject saveSubject(Subject subject) {
		return subjectrepo.save(subject);
		
	}

	public void deleteSubject(Long subjectId) {

		subjectrepo.deleteById(subjectId);
		
	}

	

	public Subject addSubjectToCourse(long subjectId, long courseId) {
		
		Course course=courserepo.findById(courseId).orElseThrow(()->
		new RuntimeException("Course Not Found"));
		
		Subject sub=subjectrepo.findById(subjectId).orElseThrow(()->
		new RuntimeException("subject not found"));
		
		sub.setCourse(course);
		
		return subjectrepo.save(sub);
	}

	public Subject getSubjectById(long subjectId) {
		
		return subjectrepo.findById(subjectId).orElseThrow(()->
		new RuntimeException("Subject not found"));
		
	}
	
}
