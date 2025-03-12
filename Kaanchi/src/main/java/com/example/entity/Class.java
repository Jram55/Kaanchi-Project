package com.example.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="classes")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Class {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ClassId")
	private long classId;
	
	@Column(name="className")
	private String className;
	
	
	@ManyToOne
	@JoinColumn(name="occpyingroom")
	private  Room room;
	
	@Column(name="inchargeStaff")
	private int inchargeStaff;
	
	private long recordId;
	
	@Column(name="deleted")
	private boolean deleted;
	
	
	
	
	
	
}
