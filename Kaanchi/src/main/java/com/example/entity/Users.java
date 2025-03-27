package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UserId")
	private long userId;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role roles;
	
	@Column(name="deleted")
	private boolean deleted;

}
