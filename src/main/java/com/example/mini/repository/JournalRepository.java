package com.example.mini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mini.model.Journal;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Integer> {
    
}
