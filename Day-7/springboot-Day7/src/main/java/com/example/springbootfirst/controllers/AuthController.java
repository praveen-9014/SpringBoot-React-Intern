package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.models.UserDetailsDto;
import com.example.springbootfirst.repository.RegisterDetailsRepo;
import com.example.springbootfirst.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;
    @Autowired
    private RegisterDetailsRepo registerDetailsRepo;


//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/register")
    public String addNewUser(@RequestBody UserDetailsDto registerDetails){
        return authService.addNewEmployee(registerDetails);
    }


    @GetMapping("/login")
    public String login(@RequestBody RegisterDetails registerDetails){
        return authService.authenticate(registerDetails);
    }
}
