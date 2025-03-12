package com.example.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDto {
	
	private long departmentId;

	private long staffId;

	private String staffName;

	private String staffNumber;

	private String gender;

	private Date doB;

	private Date doJ;

	private String designation;

	private String photo;

	private String qulification;

	private String specialization;

	private Date dOR;

	private String releavingReason;

	private long recordId;

	private boolean deleted;

}
