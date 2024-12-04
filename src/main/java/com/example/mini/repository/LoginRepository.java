package com.example.alimentaTec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.alimentaTec.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

}
