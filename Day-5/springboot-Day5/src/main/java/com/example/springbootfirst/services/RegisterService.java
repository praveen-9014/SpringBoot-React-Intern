package com.example.springbootfirst.services;

import com.example.springbootfirst.models.UserDetails;
import com.example.springbootfirst.repository.RegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    RegisterRepo registerRepo;

    public String createEmployee(UserDetails userDetails){
        registerRepo.save(userDetails);
        return "Registration successfully";
    }
}
