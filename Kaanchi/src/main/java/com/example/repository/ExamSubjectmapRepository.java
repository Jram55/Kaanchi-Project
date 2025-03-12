package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.ExamSubjectMap;


@Repository
public interface ExamSubjectmapRepository extends JpaRepository<ExamSubjectMap, Long>{

}
