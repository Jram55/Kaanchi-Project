package com.example.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="department")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(

	      generator = ObjectIdGenerators.PropertyGenerator.class,

	      property = "departmentId")

public class Department {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DepartmentId")
	private long departmentId;
	
	@Column(name="departmentName")
	private String departmentName;
	

   
    private String hodname;
	
	
	private long recordId;
	
	@Column(name="deleted")
	private boolean deleted;
	
	@JsonIgnore
	@OneToMany(mappedBy="department",cascade=CascadeType.ALL)
	private List<Course> course; 
	
	@OneToMany(mappedBy="department",cascade=CascadeType.ALL)
	private List<Staff> staff;
	
	
	
	
}
