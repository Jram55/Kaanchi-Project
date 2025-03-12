package com.example.entity;





import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="experience")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Experience {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ExperienceId")
	private long experienceId;

	
	@Column(name="jobType")
	private String jobType;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="orginisation")
	private String orginisation;
	
	@Column(name="DOJ")
	private Date dOj;
	
	@Column(name="DOL")
	private Date dOL;
	
	
	
	private long recordId;
	
	@Column(name="deleted")
	private boolean deleted;
	
	@OneToOne(mappedBy="experience")
	private Staff staff;
	
}
