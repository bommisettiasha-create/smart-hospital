package com.smarthospital.smart_hospital;
import jakarta.persistence.*;
@Entity
public class Appointment {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;
    public Long patientId;
    public Long doctorId;
    public String date;
    public String status;
}
