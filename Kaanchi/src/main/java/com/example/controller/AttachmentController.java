package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Attachment;
import com.example.service.AttachmentService;

@RestController
@RequestMapping("/attachment")
@CrossOrigin
public class AttachmentController {

	
	@Autowired
	private AttachmentService attachmentservice;
	
	
	
	@GetMapping
	public List<Attachment> getAll(){
		
		return attachmentservice.getallattachment();
	}
	
	
	
	@PostMapping
	public ResponseEntity<Attachment> save(@RequestBody Attachment attach){
		
		attachmentservice.saveattachment(attach);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/attachmentId")
	public void delete(@PathVariable Long attachmentId) {
		
		attachmentservice.deleteattachment(attachmentId);
	}
	
	
}
