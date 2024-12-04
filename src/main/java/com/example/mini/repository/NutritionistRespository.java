package com.example.alimentaTec.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.alimentaTec.model.Nutritionist;

@Repository
public interface NutritionistRespository extends JpaRepository<Nutritionist, Integer> {

    @Query("SELECT n FROM Nutritionist n WHERE n.nutritionistName =:nutritionistName")
    List<Nutritionist> searchbyNutritionistName (@Param("nutritionistName") String nutritionistName);


}