package com.example.mini.model;

import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
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

@Getter
@Setter
@Entity
@Table(name = "nutritionist")
public class Nutritionist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="idNutritionist")
    @JsonProperty("idNutritionist")
    private Integer idNutritionist;

    @NotBlank(message = "El nombre del nutricionista es obligatorio")
    @Size(max = 15, message = "El nombre del nutricionista no puede exceder los 100 caracteres")
    @Column(name ="nutritionistName")
    @JsonProperty("nutritionistName")
    private String nutritionistName;

    @NotBlank(message = "El apellido paterno es obligatorio")
    @Size(max = 20, message = "El apellido paterno no puede exceder los 100 caracteres")
    @Column(name ="paternalSurnameN")
    @JsonProperty("paternalSurnameN")
    private String paternalSurnameN;

    @NotBlank(message = "El apellido materno es obligatorio")
    @Size(max = 20, message = "El apellido materno no puede exceder los 100 caracteres")
    @Column(name ="maternalSurnameN")
    @JsonProperty("maternalSurnameN")
    private String maternalSurnameN;

    @NotNull(message = "La edad es obligatoria")
    @Positive(message = "La edad debe ser un número positivo")
    @Column(name ="ageN")
    @JsonProperty("ageN")
    private int ageN;

    @NotBlank(message = "El género es obligatorio")
    @Size(max = 20, message = "El género no puede exceder los 10 caracteres")
    @Column(name ="genderN")
    @JsonProperty("genderN")
    private String genderN;

    @NotBlank(message = "El registro del nutricionista es obligatorio")
    @Size(max = 100, message = "El registro del nutricionista no puede exceder los 50 caracteres")
    @Column(name ="nutritionistRegistration")
    @JsonProperty("nutritionistRegistration")
    private String nutritionistRegistration;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="idUser", referencedColumnName="idUser")
    @JsonProperty("idUser")
    private Login login;

    public Nutritionist() {
    }

    public int getIdNutritionist(){return idNutritionist;}
    public void setIdNutritionist(int idNutritionist){this.idNutritionist = idNutritionist;}

    public String getNutritionistName(){return nutritionistName;}
    public void setNutritionistName(String nutritionistName){this.nutritionistName = nutritionistName;}

    public String getPaternalSurnameN(){return paternalSurnameN;}
    public void setPaternalSurnameN(String paternalSurnameN){this.paternalSurnameN = paternalSurnameN;}

    public String getMaternalSurnameN(){return maternalSurnameN;}
    public void setMaternalSurnameN(String maternalSurnameN){this.maternalSurnameN = maternalSurnameN;}
    
    public int getAgeN(){return ageN;}
    public void setAgeN(int ageN){this.ageN = ageN;}
    
    public String getGenderN(){return genderN;}
    public void setGenderN(String genderN){this.genderN = genderN;}

    public String getNutritionistRegistration(){return nutritionistRegistration;}
    public void setNutritionistRegistration(String nutritionistRegistration){this.nutritionistRegistration = nutritionistRegistration;}

    public Login getLogin(){
        return login;
    }

    public Nutritionist(Integer idNutritionist, String nutritionistName, String paternalSurnameN, String maternalSurnameN, int ageN, String genderN, String nutritionistRegistration, Login login) {
        this.idNutritionist = idNutritionist;
        this.nutritionistName = nutritionistName;
        this.paternalSurnameN = paternalSurnameN;
        this.maternalSurnameN = maternalSurnameN;
        this.ageN = ageN;
        this.genderN = genderN;
        this.nutritionistRegistration = nutritionistRegistration;
        this.login = login;
    }
}
