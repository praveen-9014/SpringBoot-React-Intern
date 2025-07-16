package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class HelloWorldController {

    @Autowired
    private HelloWorldService hws;

    @GetMapping
    public List<Employee> getMethod(){
        return hws.getMethod();
    }

    @GetMapping("/{empId}")
    public Employee getEmployeeById(@PathVariable int empId){
        return hws.getEmployeeById(empId);
    }


    @PostMapping
    public String postMethod(@RequestBody Employee employee){
//        Employee employee = new Employee(5, "padma", "Business");
        return hws.postMethod(employee);
    }


    @PutMapping
    public String putMapping(){
        return hws.putMapping();
    }

    @PutMapping("/{id}")
    public String updateByEmployeeId(@PathVariable int id, @RequestBody  Employee employee){
        return hws.updateByEmployeeId(id, employee);
    }


    @DeleteMapping()
    public String deleteMapping(){
        return hws.deleteMapping();
    }

    @DeleteMapping("/{empId}")
    public String deleteByEmployeeId(@PathVariable int empId){
        return hws.deleteByEmployeeId(empId);
    }

}
