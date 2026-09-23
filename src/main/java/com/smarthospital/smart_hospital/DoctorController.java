package com.smarthospital.smart_hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class DoctorController {
    @Autowired
    private DoctorRepository repo;

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() { return repo.findAll(); }

    @PostMapping("/doctors")
    public Doctor addDoctor(@RequestBody Doctor doctor) { return repo.save(doctor); }

    @DeleteMapping("/doctors/{id}")
    public void deleteDoctor(@PathVariable Long id) { repo.deleteById(id); }
}