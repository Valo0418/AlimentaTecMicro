package com.example.alimentaTec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.alimentaTec.model.UserPatient;

@Repository
public interface UserPatientRepository extends JpaRepository<UserPatient, Integer> {
    @Query("SELECT u FROM UserPatient u WHERE u.userName =:userName")
    List<UserPatient> searchbyUserName (@Param("userName") String userName);
}
