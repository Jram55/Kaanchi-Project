package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.TimeTable;
import com.example.repository.TimeTableRepository;

@Service
public class TimeTableService {

	
	@Autowired
	private TimeTableRepository timetablerepo;

	public List<TimeTable> getalltimetable() {
		
		return timetablerepo.findAll();
	}

	public TimeTable savetimetable(TimeTable timetable) {
		
		return timetablerepo.save(timetable);
		
	}

	public void delettimetable(Long timetableId) {
	
		timetablerepo.deleteById(timetableId);
		
	}
}
