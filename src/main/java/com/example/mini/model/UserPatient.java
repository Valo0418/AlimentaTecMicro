package com.example.mini.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "UserPatient")
public class UserPatient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userPatientId")
    @JsonProperty("userPatientId")
    private Integer userPatientId;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 15, message = "El nombre no puede exceder los 15 caracteres")
    @Column(name = "userName", nullable = false)
    @JsonProperty("userName")
    private String userName;

    @NotBlank(message = "El apellido paterno no puede estar vacío")
    @Size(max = 10, message = "El apellido paterno no puede exceder los 20 caracteres")
    @Column(name = "paternalSurname", nullable = false)
    @JsonProperty("paternalSurname")
    private String paternalSurname;

    @NotBlank(message = "El apellido materno no puede estar vacío")
    @Size(max = 10, message = "El apellido materno no puede exceder los 20 caracteres")
    @Column(name = "maternalSurname", nullable = false)
    @JsonProperty("maternalSurname")
    private String maternalSurname;

    @NotNull(message = "La edad no puede estar vacía")
    @Positive(message = "La edad debe ser un número positivo")
    @Column(name = "age", nullable = false)
    @JsonProperty("age")
    private int age;

    @NotBlank(message = "El género no puede estar vacío")
    @Size(max = 20, message = "El género no puede exceder los 20 caracteres")
    @Column(name = "gender", nullable = false)
    @JsonProperty("gender")
    private String gender;

    @NotNull(message = "La altura no puede estar vacía")
    @Positive(message = "La altura debe ser un número positivo")
    @Column(name = "height", nullable = false)
    @JsonProperty("height")
    private float height;

    @NotNull(message = "El peso no puede estar vacío")
    @Positive(message = "El peso debe ser un número positivo")
    @Column(name = "weight", nullable = false)
    @JsonProperty("weight")
    private float weight;

    @NotBlank(message = "El sufrimiento no puede estar vacío")
    @Size(max = 50, message = "El sufrimiento no puede exceder los 50 caracteres")
    @Column(name = "suffering", nullable = false)
    @JsonProperty("suffering")
    private String suffering;

    @OneToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @JsonProperty("idUser")
    private Login login;

    public Integer getUserPatientId() {
        return userPatientId;
    }

    public void setUserPatientId(Integer userPatientId) {
        this.userPatientId = userPatientId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPaternalSurname() {
        return paternalSurname;
    }

    public void setPaternalSurname(String paternalSurname) {
        this.paternalSurname = paternalSurname;
    }

    public String getMaternalSurname() {
        return maternalSurname;
    }

    public void setMaternalSurname(String maternalSurname) {
        this.maternalSurname = maternalSurname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getSuffering() {
        return suffering;
    }

    public void setSuffering(String suffering) {
        this.suffering = suffering;
    }

    public Login getLogin(){
        return login;
    }

    public void setLogin(Login login){
        this.login = login;
    }
}
