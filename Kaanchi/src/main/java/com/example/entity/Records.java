package com.example.entity;





import java.util.Date;

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
@Table(name="records")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Records {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RecordId")
	private long recordId;
	
	private long createdBy;
	
	private long modifiedBy;
	
	
	@Column(name="createddate")
	private Date createdDate;
	
	
	@Column(name="modifieddate")
	private Date modifiedDate;
}
