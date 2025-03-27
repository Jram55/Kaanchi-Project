package com.example.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="academicyear")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcademicYear {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AcademicYearId")
	private long academicyearId;
	
	
	@Column(name="academicyear")
	private String academicYear;
	
	@Column(name="startYear")
	private int startYear;
	
	@Column(name="endYear")
	private int endYear;

	
	@ManyToOne(fetch= FetchType.EAGER)
	private Student student;
	
	
}
