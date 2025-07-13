package com.example.springbootfirst.services;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.repository.RegisterDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    RegisterDetailsRepo registerDetailsRepo;
    
    public List<RegisterDetails> getMethod(){
        return registerDetailsRepo.findAll();
    }

    public RegisterDetails getEmployeeById(int empId) {
        return registerDetailsRepo.findByEmail(String.valueOf(empId)).orElse(new RegisterDetails());
    }

//    public List<RegisterDetails> getEmployeeByJob(String job) {
//        return new ArrayList<>();
//    }

    public String addEmployee(RegisterDetails employee) {
        registerDetailsRepo.save(employee);
        return "Employee is added sucessfully";
    }

    public String updateEmployee(RegisterDetails employee) {
        int empId = employee.getEmpId();
        RegisterDetails user = registerDetailsRepo.findById(empId).orElseThrow(()-> new RuntimeException("there is not ID"));
        return "Employee is updated sucessfully";
    }

    public String deleteEmployeeById(int empId) {
        registerDetailsRepo.deleteById(empId);
        return "Employee is deleted successfully";
    }

    public String getResult() {
        return "";
    }
}
