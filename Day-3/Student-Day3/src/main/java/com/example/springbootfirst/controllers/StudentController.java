package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.Student;
import com.example.springbootfirst.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getStudentDetails(){
        return studentService.getStudentDetails();
    }

    @GetMapping("/{rollNo}")
    public Student getStudentById(@PathVariable int rollNo){
        return studentService.getStudentById(rollNo);
    }

    @PostMapping
    public String createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @DeleteMapping("/{rollNo}")
    public String deleteString(@PathVariable int rollNo){
        return studentService.deleteStudent(rollNo);
    }

    @PutMapping
    public String updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

}
