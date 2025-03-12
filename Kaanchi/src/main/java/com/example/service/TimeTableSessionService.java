package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.TimeTableSession;
import com.example.repository.TimeTableSessionRepository;

@Service
public class TimeTableSessionService {

	
	@Autowired
	private TimeTableSessionRepository timetablerepo;

	public List<TimeTableSession> getalltimetablesession() {
		
		return timetablerepo.findAll();
	}

	public TimeTableSession savetimetablesession(TimeTableSession timetable) {
		
		return timetablerepo.save(timetable);
		
	}

	public void deletetimetablesession(Long timetablesessionId) {
		
		timetablerepo.deleteById(timetablesessionId);
		
	}
}
