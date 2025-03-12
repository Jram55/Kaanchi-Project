package com.example.entity;

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
@Table(name="examstudent")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamStudentMap {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ExamStudentMapId")
	private long examstudentmapId;
	
	
	@ManyToOne
	@JoinColumn(name="StudentId")
	private Student student;
	
	
	@ManyToOne
	@JoinColumn(name="SubjectId")
	private Subject subject;
	
	
	private String allocatedHall;
	
	@Column(name="attended")
	private boolean attended;
	
	
	private long recordId;
	
	
	@Column(name="deleted")
	private boolean deleted;
}
