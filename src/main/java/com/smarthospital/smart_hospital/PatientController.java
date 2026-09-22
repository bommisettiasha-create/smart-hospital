package com.smarthospital.smart_hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientRepository repo;

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return repo.findAll();
    }

    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient patient) {
        return repo.save(patient);
    }
}