package com.smarthospital.smart_hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AdminController {
    @Autowired UserRepository userRepo;
    @Autowired AppointmentRepository appRepo;

    @GetMapping("/admin/stats")
    public Map<String, Long> stats(){
        return Map.of("doctors", userRepo.countByRole("DOCTOR"), "patients", userRepo.countByRole("PATIENT"));
    }

    @GetMapping("/search")
    public List<User> search(@RequestParam String q){
        return userRepo.findByNameContainingIgnoreCase(q);
    }
}