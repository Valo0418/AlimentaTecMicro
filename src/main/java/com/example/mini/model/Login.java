package com.example.mini.model;

import com.example.alimentaTec.enums.RolNombre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    @JsonProperty("idUser")
    private int idUser;
    
    @NotBlank(message = "Username cannot be blank")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @Column(name = "username")
    @JsonProperty("username")
    private String username;
    
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, message = "Password must be at least 6 characters")
    @Column(name = "passwordUser")
    @JsonProperty("passwordUser")
    private String passwordUser;
    
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    @Column(name = "email")
    @JsonProperty("email")
    private String email;

    @NotNull(message = "Role cannot be null") // Validación para no ser nulo
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RolNombre role;

    // Constructor vacío
    public Login() {
    }

    // Constructor con parámetros
    public Login(int idUser, String username, String passwordUser, String email, RolNombre role) {
        this.idUser = idUser;
        this.username = username;
        this.passwordUser = passwordUser;
        this.email = email;
        this.role = role;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPasswordUser() {
        return passwordUser;
    }
    
    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }  
    // Getters and Setters
    public RolNombre getRole() {
        return role;
    }

    public void setRole(RolNombre role) {
        this.role = role;
    }
}
