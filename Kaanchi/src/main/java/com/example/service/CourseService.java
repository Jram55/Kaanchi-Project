package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Course;
import com.example.entity.Student;
import com.example.repository.CourseRepository;
import com.example.repository.StudentRepository;

@Service
public class CourseService  {
	
	@Autowired
	private CourseRepository courserepo;
	
	
	@Autowired
	private StudentRepository studentrepo;

	public List<Course> getallcourse() {
		
		return courserepo.findAll();
	}

	public Course getcourseById(Long courseId) {
		
		return courserepo.findById(courseId).orElse(null);
		
	}

	public Course savecourse(Course course) {
		
		return courserepo.save(course);
		
		
	}

	public void deletecourse(Long courseId) {
		
		courserepo.deleteById(courseId);
		
	}

	public Course studentycourse(long studentId, long courseId) {
		
		Student student=studentrepo.findById(studentId).orElseThrow(()->
		new RuntimeException("student not found"));
		
		Course course=courserepo.findById(courseId).orElseThrow(()->
		new RuntimeException("Course not found"));
		
		course.setStudent(student);
		
		return courserepo.save(course);
	}

	
	

}
