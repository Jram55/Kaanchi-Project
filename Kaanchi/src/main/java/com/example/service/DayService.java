package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Day;
import com.example.repository.DayRepository;

@Service
public class DayService {

	
	@Autowired
	private DayRepository dayrepo;

	public List<Day> getalldays() {
	
		return dayrepo.findAll();
	}

	public Day savedays(Day day) {
	
		return dayrepo.save(day);
		
	}

	public void deletedays(Long dayId) {
	
		dayrepo.deleteById(dayId);
		
	}
}
