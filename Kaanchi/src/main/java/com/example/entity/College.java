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
@Data
@Table(name="college")
@NoArgsConstructor
@AllArgsConstructor
public class College {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CollegeId")
	private long collegeId;
	
	@Column(name="CollegeName")
	private String collegeName;
	
	@Column(name="logo")
	private String logo;
	
	@Column(name="RecordId")
	private long recordId;
}
