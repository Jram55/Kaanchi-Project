package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.StudentDto;
import com.example.entity.Student;
import com.example.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentrepo;

	public List<StudentDto> getallstudent() {
    
		List<Student> student=studentrepo.findAll();
		
		return student.stream().map(this::studentdto).collect(Collectors.toList());
	}
	
	private StudentDto studentdto(Student student) {
		StudentDto dto=new StudentDto();
		
		dto.setStudentId(student.getStudentId());
        dto.setStudentName(student.getStudentName());
        dto.setRollNumber(student.getRollNumber());
        dto.setRegisterNumber(student.getRegisterNumber());
        dto.setGender(student.getGender());
        dto.setDOB(student.getDOB());
        dto.setMobile(student.getMobile());
        dto.setEmail(student.getEmail());
        dto.setAadharNumber(student.getAadharNumber());
        dto.setMedium(student.getMedium());
        dto.setAdmittedYear(student.getAdmittedYear());
        dto.setDOj(student.getDOj());
        dto.setCurrentyear(student.getCurrentyear());
        dto.setPhoto(student.getPhoto());
        dto.setMotherTongue(student.getMotherTongue());
        dto.setNationality(student.getNationality());
        dto.setReligion(student.getReligion());
        dto.setCaste(student.getCaste());
        dto.setCommunityCategory(student.getCommunityCategory());
        dto.setDOL(student.getDOL());
        dto.setCompleted(student.isCompleted());
        dto.setLeavingReason(student.getLeavingReason());
        dto.setRecordId(student.getRecordId());
        dto.setDeleted(student.isDeleted());
        return dto;
	}
	

	public Student getstudentById(Long studentId) {

		return studentrepo.findById(studentId).orElse(null);

	}

	public Student savestudent(Student student) {

		return studentrepo.save(student);

	}

	public Student updatestudent(Long studentId, Student student) {

		Optional<Student> stu = studentrepo.findById(studentId);

		if (stu.isPresent()) {
			Student stu1 = new Student();

			stu1.setStudentName(stu1.getStudentName());
			stu1.setRollNumber(stu1.getRollNumber());
			stu1.setRegisterNumber(stu1.getRegisterNumber());
			stu1.setGender(stu1.getGender());
			stu1.setDOB(stu1.getDOB());
			stu1.setMobile(stu1.getMobile());
			stu1.setEmail(stu1.getEmail());
			stu1.setAadharNumber(stu1.getAadharNumber());
			stu1.setMedium(stu1.getMedium());
			stu1.setAdmittedYear(stu1.getAdmittedYear());
			stu1.setDOj(stu1.getDOj());
			stu1.setCurrentyear(stu1.getCurrentyear());
			stu1.setPhoto(stu1.getPhoto());
			stu1.setMotherTongue(stu1.getMotherTongue());
			stu1.setNationality(stu1.getNationality());
			stu1.setCaste(stu1.getCaste());
			stu1.setCommunityCategory(stu1.getCommunityCategory());
			stu1.setDOL(stu1.getDOL());
            stu1.setCompleted(stu1.isCompleted());
			stu1.setLeavingReason(stu1.getLeavingReason());

			return studentrepo.save(stu1);

		}
		return student;
	}

	public void deletestudent(Long studentId) {

		studentrepo.deleteById(studentId);

	}

}
