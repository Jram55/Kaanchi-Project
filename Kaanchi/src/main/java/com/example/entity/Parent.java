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
@Table(name = "parent")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Parent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ParentId")
	private long parentId;

	@Column(name = "parentName")
	private String parentName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "relationship")
	private String relationShip;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "email")
	private String email;

	@Column(name = "occupation")
	private String occupation;

	@Column(name = "annunalIncome")
	private String annunalIncome;

	@Column(name = "education")
	private String education;

	@Column(name = "guardian")
	private boolean guardian;

	@Column(name = "deleted")
	private boolean deleted;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "studentid")
	private Student student;

}