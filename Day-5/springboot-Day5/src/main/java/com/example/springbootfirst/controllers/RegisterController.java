package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.UserDetails;
import com.example.springbootfirst.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/register")
public class RegisterController {

    @Autowired
    private RegisterService rs;

    @PostMapping
    public String createEmployee(@RequestBody UserDetails userDetails){
        return rs.createEmployee(userDetails);
    }
}
