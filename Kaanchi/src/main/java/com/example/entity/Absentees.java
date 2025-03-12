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
@Table(name = "absentees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Absentees {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="AbsenteesId")
	private long absenteesId;

	@ManyToOne
	@JoinColumn(name = "AttendanceId")
	private Attendance attendance;

	@ManyToOne
	@JoinColumn(name = "StudentId")
	private Student student;

	private long recordId;

	@Column(name = "deleted")
	private boolean deleted;
}
