package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.College;
import com.example.repository.CollegeRepository;

@Service
public class CollegeService {

	@Autowired
	private CollegeRepository collegerepo;

	public List<College> getallcollge() {

		return collegerepo.findAll();
	}

	public College savecollege(College coll) {

		return collegerepo.save(coll);
	}

	public College updatecollege(long collegeId, College coll) {

		Optional<College> col = collegerepo.findById(collegeId);

		if (col.isPresent()) {
			College college = new College();
			college.setCollegeName(college.getCollegeName());
			college.setLogo(college.getLogo());
			return collegerepo.save(college);
		}
		return coll;

	}

	public void deletecollege(long collegeId) {
		collegerepo.deleteById(collegeId);

	}
}
