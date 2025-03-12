package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="acadamichistory")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class AcademicHistory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AcademicId")
	private long academicId;
	
	
	@Column(name="course")
	private String course;
	
	@Column(name="courseType")
	private String courseType;
	
	@Column(name="marks")
	private int marks;
	
	@Column(name="totalMarks")
	private int totalMarks;
	
	@Column(name="grade")
	private String grade;
	
	@Column(name="institude")
	private String institude;
	
	@Column(name="completedYear")
	private int completedYear;
	
	@Column(name="completedMonth")
	private String completedMonth;
	
	
	private int ownerId;
	
	@Column(name="ownerType")
	private String ownerType;
	
	
	private long recordId;
	
	
	
}
