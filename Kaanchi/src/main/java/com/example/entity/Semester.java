package com.example.entity;

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
@Table(name="semester")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Semester {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SemesterId")
	private long semesterId;
	
	@Column(name="semetername")
	private String semeterName;
	
	@Column(name="semetertype")
	private String semeterType;
	
	
	@Column(name="deleted")
	private boolean deleted;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Subject> subjcet;
}
