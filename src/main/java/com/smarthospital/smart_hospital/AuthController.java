package com.smarthospital.smart_hospital;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins="*")
public class AuthController {
  @PostMapping("/login")
  public Map<String,Object> login(@RequestBody Map<String,String> b){
    String email=b.get("email"); String pass=b.get("password");
    Map<String,Object> res=new HashMap<>();
    if("admin@gmail.com".equals(email)) {res.put("role","ADMIN"); res.put("userId",1); return res;}
    if("doctor@gmail.com".equals(email) || email.contains("asha") || email.toLowerCase().contains("doctor")) {res.put("role","DOCTOR"); res.put("userId",2); res.put("name",email.split("@")[0]); return res;}
    if("patient@gmail.com".equals(email) || email.contains("ruchi") || email.toLowerCase().contains("patient")) {res.put("role","PATIENT"); res.put("userId",3); res.put("name",email.split("@")[0]); return res;}
    // For any newly added user - allow login
    if(email!=null && pass!=null &&!email.isEmpty()) {
        String role = email.toLowerCase().contains("doc")? "DOCTOR" : "PATIENT";
        if(email.equals("admin@gmail.com")) role="ADMIN";
        res.put("role",role); res.put("userId", new Random().nextInt(100)); res.put("name",email.split("@")[0]); return res;
    }
    res.put("message","Invalid"); return res;
  }
}