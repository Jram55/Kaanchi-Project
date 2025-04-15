package com.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "subject")
@Data
@AllArgsConstructor
@NoArgsConstructor

@JsonIdentityInfo(

		generator = ObjectIdGenerators.PropertyGenerator.class,

		property = "subjectId")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SubjectId")
	private long subjectId;

	@Column(name = "subjectName")
	private String subjectName;

	@Column(name = "subjectCode")
	private String subjectCode;

	@Column(name = "subjectType")
	private String subjectType;

	private long recordId;

	@Column(name = "deleted")
	private boolean deleted;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CourseId")
	@JsonBackReference
	private Course course;

	@ManyToOne
	@JoinColumn(name = "Semester")
	private Semester semeter;

}
