package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Records;

@Repository
public interface RecordsRepository extends JpaRepository<Records, Long>{

}
