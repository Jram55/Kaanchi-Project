package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Exam;

@Repository
public interface  ExamRepository extends JpaRepository<Exam, Long>{

}
