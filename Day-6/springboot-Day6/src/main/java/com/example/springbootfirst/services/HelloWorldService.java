package com.example.springbootfirst.services;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HelloWorldService {

    @Autowired
    EmployeeRepo employeeRepo;

    public List<Employee> getMethod(){
        return employeeRepo.findAll();
    }

    public String getResult(){
        return "hello world";
    }

    public Employee getEmployeeById(int empId) {
        return employeeRepo.findById(empId).orElse(new Employee());
    }

    public List<Employee> getEmployeeByJob(String job) {
        return employeeRepo.findByJob(job);
    }

    public String addEmployee(Employee employee){
        employeeRepo.save(employee);
        return "Employee Added Sucessfully";
    }

    public String updateEmployee(Employee employee) {
        Optional<Employee> existingEmp = employeeRepo.findById(employee.getEmpIdl());

        if (existingEmp.isPresent()) {
            employeeRepo.save(employee);
            return "Employee updated successfully";
        } else {
            return "Employee with ID " + employee.getEmpIdl() + " not found.";
        }
    }


    public String deleteEmployeeById(int empId){
        employeeRepo.deleteById(empId);
        return "Employee is deleted";
    }

}
