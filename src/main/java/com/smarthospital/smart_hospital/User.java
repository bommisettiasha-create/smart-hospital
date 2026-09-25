package com.smarthospital.smart_hospital;
import jakarta.persistence.*;
@Entity
@Table(name="users")
public class User {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String email;
    public String password;
    public String role; // ADMIN, DOCTOR, PATIENT
    // Getters Setters
    public Long getId(){return id;} public String getRole(){return role;}
    public String getEmail(){return email;} public String getName(){return name;}
}
