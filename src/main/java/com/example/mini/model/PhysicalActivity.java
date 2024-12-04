package com.example.alimentaTec.model;

import com.example.alimentaTec.enums.Intensity;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table (name="physicalactivity")
public class PhysicalActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idActivity")
    @JsonProperty("idActivity")
    private Integer idActivity;
    
    @NotBlank(message = "The activity name cannot be empty")
    @Column(name = "nameActivity")
    @JsonProperty("nameActivity")
    private String nameActivity;

    @NotNull(message = "Duration cannot be null")
    @Pattern(regexp = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$", 
            message = "Duration format must be HH:mm:ss")
    @Column(name = "duration")
    @JsonProperty("duration")
    private String duration;

    @NotNull(message = "caloriesBurned cannot be null")
    @Column(name = "caloriesBurned")
    @JsonProperty("caloriesBurned")
    @PositiveOrZero(message = "Calories burned must be 0 or positive")
    private float caloriesBurned;

    @NotNull(message = "Intensity cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "intensity")
    @JsonProperty("intensity")
    private Intensity intensity;

    public Integer getIdActivity(){return idActivity;}
    public void setIdActivity(Integer idActivity){this.idActivity = idActivity;}

    public String getNameActivity(){return nameActivity;}
    public void setNameActivity(String nameActivity){this.nameActivity = nameActivity;}
    
    public String getDuration(){return duration;}
    public void setDuration(String duration){this.duration = duration;}

    public float getCaloriesBurned(){return caloriesBurned;}
    public void setCaloriesBurned(float caloriesBurned){this.caloriesBurned = caloriesBurned;}

    public Intensity getIntensity(){return intensity;}
    public void setIntensity(Intensity intensity){this.intensity = intensity;}
}
