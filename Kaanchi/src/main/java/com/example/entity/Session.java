package com.example.entity;



import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="session")
@AllArgsConstructor
@NoArgsConstructor
public class Session {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SessionId")
	private long sessionId;
	
	@Column(name="sessionname")
	private String sessionName;
	
	@Column(name="starttime")
	private Date startTime;
	
	@Column(name="endtime")
	private Date endTime;
	
	@Column(name="sessiontype")
	private String sessionType;
	
	
	private long recordId;
	
	@Column(name="deleted")
	private boolean deleted;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<TimeTableSession> timetablesession;
}
