package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.Student;
import com.example.springbootfirst.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public List<Student> getStudentDetails(){
        return studentService.getStudentDetails();
    }

    @GetMapping("/name")
    public String getStudentName(){
        return studentService.studentName();
    }

    @GetMapping("/age")
    public String getStudentAge(){
        return studentService.studentAge();
    }

    @GetMapping("/mobileNumber")
    public String getMobileNumber(){
        return studentService.studentMobileNumber();
    }
}
