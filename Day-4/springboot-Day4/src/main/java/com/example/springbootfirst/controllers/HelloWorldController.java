package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("job/{job}")
    public List<Employee> getEmployeeByJob(@PathVariable String job){
        return hws.getEmployeeByJob(job);
    }


    @PostMapping
    public String postMethod(@RequestBody Employee employee){
//        Employee employee = new Employee(5, "padma", "Business");
        return hws.addEmployee(employee);
    }


    @PutMapping
    public String putMapping(@RequestBody Employee employee){
        return hws.updateEmployee(employee);
    }

//
//    @PutMapping("/{id}")
//    public String updateByEmployeeId(@PathVariable int id, @RequestBody  Employee employee){
//        return hws.updateByEmployeeId(id, employee);
//    }
//
//


    @DeleteMapping("/{empId}")
    public String deleteByEmployeeId(@PathVariable int empId){
        return hws.deleteEmployeeById(empId);
    }

}
