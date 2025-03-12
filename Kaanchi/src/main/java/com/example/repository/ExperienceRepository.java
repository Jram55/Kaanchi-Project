package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long>{

}
