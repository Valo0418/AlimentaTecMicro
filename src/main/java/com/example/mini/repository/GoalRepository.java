package com.example.alimentaTec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.alimentaTec.model.Goal;


@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer> {
    
    @Query("SELECT g FROM Goal g WHERE g.nameGoal = :nameGoal")
    List<Goal> buscarPorNombre(@Param("nameGoal") String nameGoal);
           
}
