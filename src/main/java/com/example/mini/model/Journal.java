package com.example.alimentaTec.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import lombok.Getter; // Importar Lombok
import lombok.Setter; // Importar Lombok

@Getter // Generar getters automáticamente
@Setter // Generar setters automáticamente
@Entity
@Table(name = "journal")
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idJournal")
    @JsonProperty("idJournal")
    private Integer idJournal;

    @NotNull(message = "Saucer cannot be null") // Validación para no estar vacío
    @ManyToOne
    @JoinColumn(name = "idSaucer")
    @JsonProperty("saucer")
    private Saucer saucer;

    @NotNull(message = "Physical activity cannot be null") // Validación para no estar vacío
    @ManyToOne
    @JoinColumn(name = "idActivity")
    @JsonProperty("physicalActivity")
    private PhysicalActivity physicalActivity;

    @NotNull(message = "Goal cannot be null") // Validación para no estar vacío
    @ManyToOne
    @JoinColumn(name = "idGoal")
    @JsonProperty("goal")
    private Goal goal;

    @NotNull(message = "User cannot be null") // Validación para no estar vacío
    @ManyToOne
    @JoinColumn(name = "idUser")
    @JsonProperty("login")
    private Login login;
    
    public Journal(){
    }

    public Journal(Integer idJournal, Saucer saucer, PhysicalActivity physicalActivity, Goal goal, Login login){
        this.idJournal = idJournal;
        this.saucer = saucer;
        this.physicalActivity  = physicalActivity;
        this.goal = goal;
        this.login = login;
    }

    public Integer getIdJournal() {return idJournal;}
    public void setIdJournal(Integer idJournal) {this.idJournal = idJournal;}

    public Saucer getSaucer(){return saucer;}
    public void setSaucer(Saucer saucer){this.saucer = saucer;}

    public PhysicalActivity getPhysicalActivity() {return physicalActivity;}
    public void setPhysicalActivity(PhysicalActivity physicalActivity) {this.physicalActivity = physicalActivity;}

    public Goal getGoal() {return goal;}
    public void setGoal(Goal goal) {this.goal = goal;}

    public Login getLogin() {return login;}
    public void setLogin(Login login) {this.login = login;}
}
