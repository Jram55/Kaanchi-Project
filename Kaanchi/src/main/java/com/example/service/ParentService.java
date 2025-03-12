package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ParentRequest;
import com.example.entity.Parent;
import com.example.entity.Student;
import com.example.repository.ParentRepository;
import com.example.repository.StudentRepository;

@Service
public class ParentService {

	@Autowired
	private ParentRepository parentRepository;

	@Autowired
	private StudentRepository studentRepository;

	public List<Parent> getAllParents() {
		return parentRepository.findAll();
	}

	public Parent getParentById(Long parentId) {
		return parentRepository.findById(parentId).orElseThrow(() -> new RuntimeException("Parent not found"));
	}

	public Parent saveParent(ParentRequest parentRequest) {
	    // Check if studentId is null
	    if (parentRequest.getStudentId() == null) {
	        throw new IllegalArgumentException("Student ID must not be null");
	    }

	    // Find student by ID
	    Student student = studentRepository.findById(parentRequest.getStudentId())
	            .orElseThrow(() -> new RuntimeException("Student not found"));

	    Parent parent = new Parent();
	    parent.setParentName(parentRequest.getParentName());
	    parent.setGender(parentRequest.getGender());
	    parent.setRelationShip(parentRequest.getRelationShip());
	    parent.setMobile(parentRequest.getMobile());
	    parent.setEmail(parentRequest.getEmail());
	    parent.setOccupation(parentRequest.getOccupation());
	    parent.setAnnunalIncome(parentRequest.getAnnunalIncome());
	    parent.setEducation(parentRequest.getEducation());
	    parent.setGuardian(parentRequest.isGuardian());
	    parent.setDeleted(false);

	    // Assign student to parent
	    parent.setStudent(student);

	    return parentRepository.save(parent);
	}


	public void deleteParent(Long parentId) {
		parentRepository.deleteById(parentId);
	}
}
