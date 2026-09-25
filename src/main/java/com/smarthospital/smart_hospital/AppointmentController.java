package com.smarthospital.smart_hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    AppointmentRepository repo;

    @PostMapping("/book")
    public Appointment book(@RequestBody Appointment a){ 
        a.status="BOOKED"; 
        return repo.save(a); 
    }

    @GetMapping("/patient/{id}")
    public List<Appointment> byPatient(@PathVariable Long id){ 
        return repo.findByPatientId(id); 
    }
}