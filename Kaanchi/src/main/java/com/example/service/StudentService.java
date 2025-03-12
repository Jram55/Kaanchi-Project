package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentrepo;

	public List<Student> getallstudent() {

		return studentrepo.findAll();
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
