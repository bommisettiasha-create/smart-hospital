package com.smarthospital.smart_hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class BillingController {

    @Autowired
    BillingRepository billRepo;

    @Autowired
    AppointmentRepository appRepo;

    @Autowired
    PrescriptionRepository preRepo;

    @PostMapping("/billing")
    public Billing gen(@RequestBody Billing b){
        b.status="PAID";
        return billRepo.save(b);
    }

    @GetMapping("/history/{patientId}")
    public Map<String, Object> history(@PathVariable Long patientId){
        Map<String, Object> map = new HashMap<>();
        map.put("appointments", appRepo.findByPatientId(patientId));
        map.put("prescriptions", preRepo.findByPatientId(patientId));
        return map;
    }
}