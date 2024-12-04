package com.example.alimentaTec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.alimentaTec.model.Journal;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Integer> {
    
}
