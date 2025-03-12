package com.example.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="exam")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exam {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ExamId")
	private long examId;
	
	@Column(name="examtitle")
	private String examTitle;
	
	@Column(name="examtype")
	private String examType;
	
	@Column(name="month")
	private String month;
	
	@Column(name="year")
	private int year;
	
	@Column(name="maxtime")
	private int maxtime;
	
	@Column(name="maxmark")
	private int maxmark;
	
	private long recordId;
	
	@Column(name="deleted")
	private boolean deleted;
	
	
	
}
