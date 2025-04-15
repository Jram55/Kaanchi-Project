package com.example.dto;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

	private long studentId;

	private String studentName;

	private String rollNumber;

	private String registerNumber;

	private String gender;

	private Date dOB;

	private String mobile;

	private String email;

	private String aadharNumber;

	private String medium;

	private String admittedYear;

	private Date dOj;

	private int currentyear;

	private String photo;

	private String motherTongue;

	private String nationality;

	private String religion;

	private String caste;

	private String communityCategory;

	private Date dOL;

	private boolean completed;

	private String leavingReason;

	private long recordId;

	private boolean deleted;

	

}
