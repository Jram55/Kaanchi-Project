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
@Table(name="staffsubjectmap")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffSubjectMap {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="StaffSubjectId")
	private long staffSubjectId;
	
	
	@ManyToOne
	@JoinColumn(name="StaffId")
	private Staff staff;
	
	
	@ManyToOne
	@JoinColumn(name="SubjectId")
	private Subject subject;
	
	
	private long recordId;
	
	@Column(name="deleted")
	private boolean deleted;

}
