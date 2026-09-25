package com.smarthospital.smart_hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/doctors")
    public List<User> getDoctors() {
        return userRepo.findByRole("DOCTOR");
    }

    @GetMapping("/patients")
    public List<User> getPatients() {
        return userRepo.findByRole("PATIENT");
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");
        User u = userRepo.findByEmail(email);
        if (u != null && u.password.equals(password)) {
            return u;
        }
        return null;
    }
}