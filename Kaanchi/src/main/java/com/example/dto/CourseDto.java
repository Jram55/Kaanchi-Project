package com.example.dto;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {	

	private long courseId;

	private String courseName;

	private String courseType;

	private int years;

	private long recordId;

	private boolean deleted;
	
	private List<SubjectDto> subject;

	
}
