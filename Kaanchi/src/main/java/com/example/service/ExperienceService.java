package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Experience;
import com.example.repository.ExperienceRepository;

@Service
public class ExperienceService {

	
	@Autowired
	private ExperienceRepository experiencerepo;

	public List<Experience> getallexperience() {
		
		return experiencerepo.findAll();
	}

	public Experience getexperienceById(Long experienceId) {
		
		return experiencerepo.findById(experienceId).orElse(null);
		
	}

	public Experience saveexperience(Experience experience) {
		
		return experiencerepo.save(experience);
		
	}

	public Experience upadteExperienece(Long experienceId, Experience experience) {
		
		Optional<Experience> exp=experiencerepo.findById(experienceId);
		if(exp.isPresent()) {
			Experience exp1=new Experience();
			exp1.setJobType(exp1.getJobType());
			exp1.setDesignation(exp1.getDesignation());
			exp1.setOrginisation(exp1.getOrginisation());
			exp1.setDOj(exp1.getDOj());
			exp1.setDOL(exp1.getDOL());
			exp1.setStaff(exp1.getStaff());
			
			return experiencerepo.save(exp1);
			
		}
		return experience;
		
	}

	public void deleteexperience(Long experienceId) {


		experiencerepo.deleteById(experienceId);
		
	}
	
	
}
