package com.example.alimentaTec.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank; // Importa las anotaciones de validación
import jakarta.validation.constraints.Size; // Importa las anotaciones de validación

@Getter
@Setter
@Entity
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGoal")
    @JsonProperty("idGoal")
    private int idGoal;

    @Column(name = "nameGoal")
    @JsonProperty("nameGoal")
    @NotBlank(message = "Name is mandatory") // Validación
    @Size(min = 1, max = 30, message = "Name must be between 1 and 50 characters") // Validación
    private String nameGoal;

    @Column(name = "descriptionGoal")
    @JsonProperty("descriptionGoal")
    @NotBlank(message = "description cannot be null")
    @Size(max = 255, message = "Description must be at most 255 characters") // Validación
    private String descriptionGoal;

    
    @NotBlank(message = "startGoal cannot be null")
    @Column(name = "startGoal")
    @JsonProperty("startGoal")
    private boolean startGoal;

    
    @NotBlank(message = "endGoal cannot be null")
    @Column(name = "endGoal")
    @JsonProperty("endGoal")
    private boolean endGoal;

    @Column(name = "statusGoal")
    @JsonProperty("statusGoal")
    @NotBlank(message = "Status is mandatory") // Validación
    private String statusGoal;

    // Getters and Setters
    public int getIdGoal() {
        return idGoal;
    }

    public void setIdGoal(int idGoal) {
        this.idGoal = idGoal;
    }

    public String getNameGoal() {
        return nameGoal;
    }

    public void setNameGoal(String nameGoal) {
        this.nameGoal = nameGoal;
    }

    public String getDescriptionGoal() {
        return descriptionGoal;
    }

    public void setDescriptionGoal(String descriptionGoal) {
        this.descriptionGoal = descriptionGoal;
    }

    public boolean getStartGoal() {
        return startGoal;
    }

    public void setStartGoal(boolean startGoal) {
        this.startGoal = startGoal;
    }

    public boolean getEndGoal() {
        return endGoal;
    }

    public void setEndGoal(boolean endGoal) {
        this.endGoal = endGoal;
    }

    public String getStatusGoal() {
        return statusGoal;
    }

    public void setStatusGoal(String statusGoal) {
        this.statusGoal = statusGoal;
    }

    public Goal() {
        
    }

    public Goal(String nameGoal, String descriptionGoal, boolean startGoal, boolean endGoal, String statusGoal) {
        this.nameGoal = nameGoal;
        this.descriptionGoal = descriptionGoal;
        this.startGoal = startGoal;
        this.endGoal = endGoal;
        this.statusGoal = statusGoal;
    }

}
