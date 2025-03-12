package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Class;
import com.example.repository.ClassRepository;

@Service
public class ClassService {

	@Autowired
	private ClassRepository classrepo;

	public List<Class> getallclass() {
	
		return classrepo.findAll();
	}

	public Class saveclass(Class classes) {
	
		return classrepo.save(classes);
		
	}

	public void deleteclass(Long classId) {
		
		classrepo.deleteById(classId);
		
	}

	
}
