package com.example.entity;





import java.util.Date;

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
@Table(name="examsubject")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamSubjectMap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ExamSubjectMapId")
	private long examsubjectmapId;
	
	@ManyToOne
	@JoinColumn(name="ExamId")
	private Exam exam;
	
	
	@ManyToOne
	@JoinColumn(name="SubjectId")
	private Subject subject;
	
	@Column(name="examdate")
	private Date examdate;
	
	
	private long recordId;
	
	@Column(name="deleted")
	private boolean deleted;
}
