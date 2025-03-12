package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.TimeTable;

@Repository
public interface TimeTableRepository extends JpaRepository<TimeTable, Long>{

}
