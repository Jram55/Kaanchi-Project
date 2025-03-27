package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.AcademicYearDto;
import com.example.entity.AcademicYear;
import com.example.service.AcademicYearService;

@RestController
@RequestMapping("/academicyear")
@CrossOrigin
public class AcadamicYearController {

	@Autowired
	private AcademicYearService acadamicservice;

	@GetMapping
	public List<AcademicYear> getall() {

		return acadamicservice.getAllacdamicyear();
	}

	@GetMapping("/academicyearId")
	public ResponseEntity<AcademicYear> getById(@PathVariable Long academicyearId) {

		acadamicservice.GetacadenicyearById(academicyearId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<AcademicYear> save(@RequestBody AcademicYear academic) {

		acadamicservice.saveacademicyear(academic);
		return new ResponseEntity<>(academic,HttpStatus.CREATED);
	}

	@DeleteMapping("/academicyaerId")
	public void delete(@PathVariable Long academicyearId) {

		acadamicservice.deleteacadamicyear(academicyearId);

	}
	
	@PostMapping("/addstudent")
	public ResponseEntity<AcademicYear> studentAcademic(@RequestBody AcademicYearDto academicyear){
		acadamicservice.studentAcademmic(academicyear.getAcademicyearId(),academicyear.getStudentId());
		return new ResponseEntity(academicyear,HttpStatus.OK);
	}
}
