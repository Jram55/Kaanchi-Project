package com.example.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="timetable")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeTable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TimeTableId")
	private long timetableId;
	
	
	@ManyToOne
	@JoinColumn(name="Class")
	private Class classes;
	
	@OneToOne
	@JoinColumn(name="Day")
	private Day day;
	
	
	private long recordId;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<TimeTableSession> timetablesession;
	
	
	
}
