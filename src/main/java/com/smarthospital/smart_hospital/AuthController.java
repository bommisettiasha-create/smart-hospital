package com.smarthospital.smart_hospital;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> body){
        String email = body.get("email");
        String password = body.get("password");
        Map<String, Object> res = new HashMap<>();
        
        if("admin@gmail.com".equals(email) && "123".equals(password)){
            res.put("role","ADMIN"); res.put("userId",1);
        } else if("doctor@gmail.com".equals(email) && "123".equals(password)){
            res.put("role","DOCTOR"); res.put("userId",2);
        } else if("patient@gmail.com".equals(email) && "123".equals(password)){
            res.put("role","PATIENT"); res.put("userId",3);
        } else {
            res.put("message","Invalid Credentials - Use admin@gmail.com / 123");
        }
        return res;
    }
}