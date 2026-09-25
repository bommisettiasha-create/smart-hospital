package com.smarthospital.smart_hospital;

import jakarta.persistence.*;

@Entity
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Long patientId;
    public Long amount;
    public String status;
}