package com.example.entity;






import java.util.Date;

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
@Table(name="leaves")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Leaves {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LeaveId")
	private long leaveId;
	
	@ManyToOne
	@JoinColumn(name="StudentId")
	private Student student;
	
	@Column(name="fromdate")
	private Date fromdate;
	
	@Column(name="todate")
	private Date todate;
	
	
	@ManyToOne
	@JoinColumn(name="ApprovedStaff")
	private Staff staff;

	private long recordId;
	
	
	@Column(name="deleted")
	private boolean deleted;

}
