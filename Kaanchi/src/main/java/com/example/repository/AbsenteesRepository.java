package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Absentees;

@Repository
public interface AbsenteesRepository extends JpaRepository<Absentees, Long> {

}
