package com.example.mini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mini.model.PhysicalActivity;

@Repository
public interface PhysicalActivityRepository extends JpaRepository<PhysicalActivity, Integer> {
    
}
