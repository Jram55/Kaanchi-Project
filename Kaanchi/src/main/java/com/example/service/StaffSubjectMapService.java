package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.StaffSubjectMap;
import com.example.repository.StaffSubjcetMapRepository;

@Service
public class StaffSubjectMapService {

	
	@Autowired
	private StaffSubjcetMapRepository staffsubjectrepo;

	public List<StaffSubjectMap> getAllstaffsubject() {
	
		return staffsubjectrepo.findAll();
	}

	public StaffSubjectMap savestaffsubject(StaffSubjectMap staffsubject) {
		 
		return staffsubjectrepo.save(staffsubject);
		
	}

	public void deletestaffsubject(Long staffsubjectId) {
		
		staffsubjectrepo.deleteById(staffsubjectId);
		
	}
}
