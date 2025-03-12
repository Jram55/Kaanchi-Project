package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long>{

}
