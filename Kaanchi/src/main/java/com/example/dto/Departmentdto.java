package com.example.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departmentdto {

	private long departmentId;
	private String departmentName;
	private String hodname;
	private long recordId;
	private boolean deleted;
	private List<CourseDto> course;
	
}
