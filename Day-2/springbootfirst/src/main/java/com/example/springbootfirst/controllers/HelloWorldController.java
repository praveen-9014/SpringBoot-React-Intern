package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldService hws;

    @GetMapping("/")
    public List<Employee> getMethod(){
        return hws.getMethod();
    }

//    @GetMapping("/")
//    public String hello(){
//        return hws.helloWorld();
//    }


    @PostMapping("/")
    public String postMethod(){
        return hws.postMethod();
    }


    @PutMapping
    public String putMapping(){
        return hws.putMapping();
    }


    @DeleteMapping
    public String deleteMapping(){
        return hws.deleteMapping();
    }

}
