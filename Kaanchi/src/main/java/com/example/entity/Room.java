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
@Table(name="room")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RoomId")
	private long  roomId;
	
	@Column(name="roomname")
	private String roomName;
	
	@Column(name="roomlocation")
	private String roomLocation;
	
	@Column(name="classcapcity")
	private int classcapcity;
	
	@Column(name="examcapcity")
	private int examcapcity;
	
	@Column(name="deleted")
	private boolean deleted;
	
	
	@OneToMany(cascade=CascadeType.ALL)
    private List<TimeTableSession> timetablesession;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Class> classes;
}
