package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubjectDto {

	

	private String subjectName;

	private String subjectCode;

	private String subjectType;

	private long recordId;

	private boolean deleted;

}
