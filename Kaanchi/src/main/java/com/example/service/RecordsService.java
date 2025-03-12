package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Records;
import com.example.repository.RecordsRepository;

@Service
public class RecordsService {

	
	@Autowired
	private RecordsRepository recordsrepo;

	public List<Records> getallrecords() {
		
		return recordsrepo.findAll();
	}

	public Records getrecordById(Long recordId) {
		
		return recordsrepo.findById(recordId).orElse(null);
		
	}

	public Records  saverecord(Records records) {
		
		return recordsrepo.save(records);
		
	}

	public void deleterecord(Long recordId) {
		
		recordsrepo.deleteById(recordId);
		
	}
	
	
}
