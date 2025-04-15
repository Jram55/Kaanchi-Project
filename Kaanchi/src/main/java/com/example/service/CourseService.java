package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CourseDto;
import com.example.dto.SubjectDto;
import com.example.entity.Course;
import com.example.entity.Student;
import com.example.repository.CourseRepository;
import com.example.repository.StudentRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courserepo;

	@Autowired
	private StudentRepository studentrepo;

	public List<CourseDto> getallCourse() {
		List<Course> courses = courserepo.findAll();
		return courses.stream().map(this::coursesDto).collect(Collectors.toList());
	}

	private CourseDto coursesDto(Course course) {
		CourseDto dto = new CourseDto();
		dto.setCourseId(course.getCourseId());
		dto.setCourseName(course.getCourseName());
		dto.setCourseType(course.getCourseType());
		dto.setYears(course.getYears());
		dto.setRecordId(course.getRecordId());
		dto.setDeleted(course.isDeleted());
		return dto;
	}

	public CourseDto getcourseById(Long courseId) {

		Course course = courserepo.findById(courseId).orElseThrow(() -> new RuntimeException("Course Not Found"));

		CourseDto coursedto = new CourseDto();
		coursedto.setCourseId(course.getCourseId());
		coursedto.setCourseName(course.getCourseName());
		coursedto.setCourseType(course.getCourseType());
		coursedto.setYears(course.getYears());
		coursedto.setDeleted(course.isDeleted());

		List<SubjectDto> subjectdto = course.getSubject().stream().map(subject -> {

			SubjectDto sub = new SubjectDto();

			sub.setSubjectName(subject.getSubjectName());
			sub.setSubjectCode(subject.getSubjectCode());
			sub.setSubjectType(subject.getSubjectType());
			sub.setDeleted(subject.isDeleted());
			return sub;
		}).collect(Collectors.toList());

		coursedto.setSubject(subjectdto);
		return coursedto;

	}

	public Course savecourse(Course course) {

		return courserepo.save(course);

	}

	public void deletecourse(Long courseId) {

		courserepo.deleteById(courseId);

	}

	public Course studentycourse(long studentId, long courseId) {

		Student student = studentrepo.findById(studentId).orElseThrow(() -> new RuntimeException("student not found"));

		Course course = courserepo.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));

		course.setStudent(student);

		return courserepo.save(course);
	}

}
