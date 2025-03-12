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
@Table(name="timetablesession")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeTableSession {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TimeTableSessionId")
	private long timetablesessionId;
	
	
	@ManyToOne
	@JoinColumn(name="TimeTableId")
	private TimeTable timetable;
	
	
	@ManyToOne
	@JoinColumn(name="SessionId")
	private Session session;
	
	
	@ManyToOne
	@JoinColumn(name="SubjectId")
	private Subject subject;
	
	
	@ManyToOne
	@JoinColumn(name="StaffId")
	private Staff staff;
	
	
	@ManyToOne
	@JoinColumn(name="occuyingRoom")
	private Room room;
	
	
}
