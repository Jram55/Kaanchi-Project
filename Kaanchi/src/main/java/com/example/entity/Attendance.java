package com.example.entity;



import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="attendance")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Attendance {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AttendanceId")
	private long attendanceId;
	
	
	@Column(name="attendancedate")
	private Date attendancedate;
	
	
	@ManyToOne
	@JoinColumn(name="Class_id")
	private Class classes;
	
	
	@ManyToOne
	@JoinColumn(name="Session_id")
	private Session session;
	
	
	@ManyToOne
	@JoinColumn(name="Staff_id")
	private Staff staff;
	
	private long recordId;
	
	
	@Column(name="deleted")
	private boolean deleted;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Student> student;
	
}
