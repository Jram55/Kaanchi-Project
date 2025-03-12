package com.example.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

	private long studentId;

	private long departmentId;

	private long courseId;

	private String courseName;

	private String courseType;

	private int years;

	private long recordId;

	private boolean deleted;

}
