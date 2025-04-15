package com.example.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CourseId")
	private long courseId;

	@Column(name = "courseName")
	private String courseName;

	@Column(name = "courseType")
	private String courseType;

	@Column(name = "years")
	private int years;

	private long recordId;

	@Column(name = "deleted")
	private boolean deleted;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id")
	@JsonBackReference
	private Department department;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id")
	@JsonBackReference
	private Student student;

	@JsonManagedReference
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<Subject> subject;

}
