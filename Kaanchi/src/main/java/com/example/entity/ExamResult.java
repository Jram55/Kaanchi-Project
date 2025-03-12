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
@Table(name="examresult")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamResult {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="ExamResultId")
	private long examresultId;
	
	@ManyToOne
	@JoinColumn(name="ExamId")
	private Exam exam;
	
	
	@ManyToOne
	@JoinColumn(name="StudentId")
	private Student student;
	
	@Column(name="marks")
	private int marks;
	
	private long recordId;
	
	@Column(name="deleted")
	private boolean deleted;

}
