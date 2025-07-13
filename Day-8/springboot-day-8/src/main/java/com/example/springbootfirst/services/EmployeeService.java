package com.example.springbootfirst.services;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.models.Roles;
import com.example.springbootfirst.repository.RegisterDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    RegisterDetailsRepo registerDetailsRepo;

    @Autowired
    PasswordEncoder passwordEncoder;
    
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

    public String updateEmployeeById(int id, RegisterDetails updatedData) {
        RegisterDetails existing = registerDetailsRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        existing.setName(updatedData.getName());
        existing.setUsername(updatedData.getUsername());
        existing.setEmail(updatedData.getEmail());
        existing.setPassword(passwordEncoder.encode(updatedData.getPassword()));
        existing.setRoles(updatedData.getRoles());

        registerDetailsRepo.save(existing);
        return "Employee updated successfully";
    }



    public List<RegisterDetails> findEmployeesByRole(String roleName){
        List<RegisterDetails> employees = new ArrayList<>();


        for(RegisterDetails registerDetails : registerDetailsRepo.findAll()){
            for(Roles role : registerDetails.getRoles()){
                if(role.getRoleName().equals(roleName.toUpperCase())){
                    employees.add(registerDetails);
                }
            }
        }
        return employees;
    }


    public String deleteEmployeeById(int empId) {
        registerDetailsRepo.deleteById(empId);
        return "Employee is deleted successfully";
    }

    public String getResult() {
        return "";
    }
}
