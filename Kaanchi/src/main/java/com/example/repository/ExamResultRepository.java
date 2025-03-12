package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.ExamResult;

@Repository
public interface ExamResultRepository extends JpaRepository<ExamResult, Long>{

}
