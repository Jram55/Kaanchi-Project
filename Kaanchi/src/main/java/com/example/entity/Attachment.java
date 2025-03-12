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
@Table(name="attechment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attachment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AttachmentId")
	private long attachmentId;
	
	@Column(name="path")
	private String path;
	
	
	private String owner;
	
	@Column(name="ownertype")
	private String ownerType;
	
	private long recordId;
	
	
	@Column(name="deleted")
	private boolean deleted;
}
