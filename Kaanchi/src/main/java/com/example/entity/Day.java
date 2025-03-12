package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="day")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Day {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DayId")
	private long dayId;
	
	@Column(name="dayname")
	private String  dayName;
	
	@Column(name="totalsession")
	private int totalSession;
	
	@Column(name="deleted")
	private boolean deleted;
	

}
