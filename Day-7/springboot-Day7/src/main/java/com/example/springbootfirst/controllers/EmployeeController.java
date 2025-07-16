package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.models.UserDetailsDto;
import com.example.springbootfirst.repository.RegisterDetailsRepo;
import com.example.springbootfirst.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RegisterDetailsRepo registerDetailsRepo;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/")
    public String getResult(){
        return employeeService.getResult();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/employee")
    public List<RegisterDetails> getMethod(){
        return employeeService.getMethod();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("employee/{empId}")
    public RegisterDetails getEmployeeById(@PathVariable int empId){
        return employeeService.getEmployeeById(empId);
    }

//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
//    @GetMapping("job/{job}")
//    public List<RegisterDetails> getEmployeeByJob(@PathVariable String job){
//        return employeeService.getEmployeeByJob(job);
//    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/employee")
    public String postMethod(@RequestBody RegisterDetails employee){
//        Employee employee = new Employee(5, "padma", "Business");
        return employeeService.addEmployee(employee);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/employee")
    public String putMapping(@RequestBody RegisterDetails employee){
        return employeeService.updateEmployee(employee);
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
        return employeeService.deleteEmployeeById(empId);
    }

}
