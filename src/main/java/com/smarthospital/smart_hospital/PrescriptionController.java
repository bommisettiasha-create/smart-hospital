package com.smarthospital.smart_hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/prescriptions")
public class PrescriptionController {
    @Autowired
    PrescriptionRepository repo;

    @PostMapping
    public Prescription save(@RequestBody Prescription p){ 
        return repo.save(p); 
    }

    @GetMapping("/patient/{id}")
    public List<Prescription> byPatient(@PathVariable Long id){ 
        return repo.findByPatientId(id); 
    }
}