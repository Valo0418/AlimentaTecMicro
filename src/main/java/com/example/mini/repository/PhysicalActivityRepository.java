package com.example.alimentaTec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.alimentaTec.model.PhysicalActivity;

@Repository
public interface PhysicalActivityRepository extends JpaRepository<PhysicalActivity, Integer> {
    
}
