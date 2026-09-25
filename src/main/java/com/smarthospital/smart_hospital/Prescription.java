package com.smarthospital.smart_hospital;

import jakarta.persistence.*;

@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Long patientId;
    public Long doctorId;
    public String medicines;
    public String notes;
}