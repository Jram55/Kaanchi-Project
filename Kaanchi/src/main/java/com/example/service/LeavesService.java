package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Leaves;
import com.example.repository.LeavesRepository;

@Service
public class LeavesService  {

	
	@Autowired
	private LeavesRepository leaverepo;

	public List<Leaves> getallleaves() {
		
		return leaverepo.findAll();
	}

	public Leaves saveleave(Leaves leave) {
		
		return leaverepo.save(leave);
		
	}

	public void deletleave(Long leaveId) {
		
		leaverepo.deleteById(leaveId);
		
	}
}
