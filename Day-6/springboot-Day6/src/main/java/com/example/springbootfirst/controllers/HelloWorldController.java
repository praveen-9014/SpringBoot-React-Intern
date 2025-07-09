package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/")
public class HelloWorldController {

    @Autowired
    private HelloWorldService hws;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/")
    public String getResult(){
        return hws.getResult();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/employee")
    public List<Employee> getMethod(){
        return hws.getMethod();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("employee/{empId}")
    public Employee getEmployeeById(@PathVariable int empId){
        return hws.getEmployeeById(empId);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("job/{job}")
    public List<Employee> getEmployeeByJob(@PathVariable String job){
        return hws.getEmployeeByJob(job);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/employee")
    public String postMethod(@RequestBody Employee employee){
//        Employee employee = new Employee(5, "padma", "Business");
        return hws.addEmployee(employee);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("employee")
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

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("employee/{empId}")
    public String deleteByEmployeeId(@PathVariable int empId){
        return hws.deleteEmployeeById(empId);
    }

}
