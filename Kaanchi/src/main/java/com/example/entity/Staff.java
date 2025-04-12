package com.example.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "staff")
@Data
@AllArgsConstructor
@NoArgsConstructor

@JsonIdentityInfo(

		generator = ObjectIdGenerators.PropertyGenerator.class,

		property = "staffId")
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "StaffId")
	private long staffId;

	@Column(name = "staffName")
	private String staffName;

	@Column(name = "staffNumber")
	private String staffNumber;

	@Column(name = "gender")
	private String gender;

	@Column(name = "dob")
	private Date doB;

	@Column(name = "doj")
	private Date doJ;

	@Column(name = "designation")
	private String designation;

	@Column(name = "photo")
	private String photo;

	@Column(name = "qualification")
	private String qulification;

	@Column(name = "speclization")
	private String specialization;

	@Column(name = "dor")
	private Date dOR;

	@Column(name = "releavingreson")
	private String releavingReason;

	private long recordId;

	@Column(name = "deleted")
	private boolean deleted;

	@OneToOne(cascade = CascadeType.ALL)
	private Experience experience;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id")
	private Department department;

}
