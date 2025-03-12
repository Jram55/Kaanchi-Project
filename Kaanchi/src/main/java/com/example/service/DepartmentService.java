package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Course;
import com.example.entity.Department;
import com.example.repository.CourseRepository;
import com.example.repository.DepartmentRepository;

@Service

public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentrepo;
	
	@Autowired
	private CourseRepository courserepo;

	public List<Department> getalldepartment() {
	
		return departmentrepo.findAll();
	}

	public  Department savedepartment(Department department) {
		
		return departmentrepo.save(department);
		
	}

	public void deletedepartment(Long departmentId) {
		
		departmentrepo.deleteById(departmentId);
		
	}

	public Department departmentcourse(long departmentId, long courseId) {
		
		Department department=departmentrepo.findById(departmentId).orElseThrow(()
				->new RuntimeException("department not found"));
		
		Course course=courserepo.findById(courseId).orElseThrow(()->
		new RuntimeException("Course not found"));
		
		course.setDepartment(department);
		
		return departmentrepo.save(department);
	}

	public Department getDepartmentById(long departmentId) {
		
		return departmentrepo.findById(departmentId).orElseThrow(()->
		new RuntimeException("the department not found"));
	}
}
