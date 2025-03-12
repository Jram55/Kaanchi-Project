package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Attachment;
import com.example.repository.AttachmentRepository;

@Service
public class AttachmentService {
	
	
	@Autowired
	private AttachmentRepository attachmentrepo;

	public List<Attachment> getallattachment() {
	
		return attachmentrepo.findAll();
	}

	public Attachment saveattachment(Attachment attach) {
		
		return attachmentrepo.save(attach);
		
	}

	public void deleteattachment(Long attachmentId) {
	
		attachmentrepo.deleteById(attachmentId);
		
	}
	
	
	

	
	
}
