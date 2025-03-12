package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Session;
import com.example.repository.SessionRepository;

@Service
public class SessionService {

	
	@Autowired
	private SessionRepository sessionrepo;

	public List<Session> getAllsession() {
		
		return sessionrepo.findAll();
	}

	public Session savesession(Session session) {
		
		return sessionrepo.save(session);
		
		}

	public Session updatesession(Long sessionId, Session session) {
        
		Optional<Session> ses=sessionrepo.findById(sessionId);
		
		if(ses.isPresent()) {
			Session sess=new Session();
			sess.setSessionName(sess.getSessionName());
			sess.setSessionType(sess.getSessionType());
			sess.setStartTime(sess.getStartTime());
			sess.setEndTime(sess.getEndTime());
			return sessionrepo.save(sess);
		}
		
		return session;
		
	}

	public void deletesession(Long sessionId) {
		
		sessionrepo.deleteById(sessionId);
		
	}
	
	
	
	
}
