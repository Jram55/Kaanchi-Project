package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CourseDto;
import com.example.dto.Departmentdto;
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

	public List<Departmentdto> getalldepartment() {

		List<Department> department= departmentrepo.findAll();
		return department.stream().map(this::departmentdto).collect(Collectors.toList());
	}
	
	public Departmentdto departmentdto(Department department) {
		
		Departmentdto depart=new Departmentdto();
		
		depart.setDepartmentId(department.getDepartmentId());
		depart.setDepartmentName(department.getDepartmentName());
		depart.setHodname(department.getHodname());
		depart.setDeleted(department.isDeleted());
		
		return depart;
		
	}

	public Departmentdto getDepartmentById(long departmentId) {

		Department department = departmentrepo.findById(departmentId)
				.orElseThrow(() -> new RuntimeException("the department not found"));

		Departmentdto dto = new Departmentdto();
		dto.setDepartmentId(department.getDepartmentId());
		dto.setDepartmentName(department.getDepartmentName());
		dto.setHodname(department.getHodname());
		dto.setRecordId(department.getRecordId());
		dto.setDeleted(department.isDeleted());

		List<CourseDto> courseDtos = department.getCourse().stream().map(course -> {
			CourseDto courseDto = new CourseDto();
			courseDto.setCourseId(course.getCourseId());
			courseDto.setCourseName(course.getCourseName());
			courseDto.setCourseType(course.getCourseType());
			courseDto.setYears(course.getYears());
			courseDto.setRecordId(course.getRecordId());
			courseDto.setDeleted(course.isDeleted());
			return courseDto;
		}).collect(Collectors.toList());

		dto.setCourse(courseDtos);
		return dto;

	}

	public Department savedepartment(Department department) {

		return departmentrepo.save(department);

	}

	public Department departmentcourse(long departmentId, long courseId) {

		Department department = departmentrepo.findById(departmentId)
				.orElseThrow(() -> new RuntimeException("department not found"));

		Course course = courserepo.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));

		course.setDepartment(department);

		return departmentrepo.save(department);
	}

	

	public Department upadateDepartment(long departmentId, Department department) {
	
		Department department2=departmentrepo.findById(departmentId).orElseThrow(()->
		new RuntimeException("DepartmentId Not Found"));
		
		department2.setDepartmentName(department.getDepartmentName());
		department2.setHodname(department.getHodname());
		department2.setDeleted(department.isDeleted());
		
		return departmentrepo.save(department2);
		
	}
	
	public void deletedepartment(Long departmentId) {

		departmentrepo.deleteById(departmentId);

	}
}
