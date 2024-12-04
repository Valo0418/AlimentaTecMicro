package com.example.mini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mini.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

}
