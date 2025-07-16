package com.example.springbootfirst.services;

import com.example.springbootfirst.models.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {

    List<Employee> employees = new ArrayList<>(
            Arrays.asList(new Employee(1, "praveen", "developer"), new Employee(2, "jack", "Tester"))
    );


    public List<Employee> getMethod(){
        return employees;
    }

    public Employee getEmployeeById(int empId){
        int ind = 0;
        boolean flag = false;
        for(int i=0;i<employees.size();i++){
            if(empId == employees.get(i).getEmpIdl()){
                System.out.println("Emp_Id" + employees.get(i).getEmpIdl() + employees.get(i));
                ind = i;
                flag = true;
                break;
            }
        }

        if(flag){
           return employees.get(ind);
        }
        else{
            return new Employee();
        }
    }

    public String deleteByEmployeeId(int empId){
        boolean flag = false;
        int ind = 0;
        for(int i=0;i<employees.size();i++){
            if(empId == employees.get(i).getEmpIdl()){
                ind = i;
                flag = true;
                break;
            }
        }

        if(flag){
            employees.remove(ind);
            return "Employee is Deleted by ID";
        }
        else{
            return "Enter the correct employee Id to delete";
        }
    }

    public String updateByEmployeeId(int empId, Employee employee){
        boolean flag = false;
        int ind = 0;
        for(int i=0;i<employees.size();i++){
            if(empId == employees.get(i).getEmpIdl()){
                ind = i;
                flag = true;
                break;
            }
        }

        if(flag){
            employees.set(ind, employee);
            return "employee details is updated";
        }
        else{
            return "Enter the correct employee id";
        }
    }


    public String postMethod(Employee employee){
        employees.add(employee);

        return "Employee is added successfully";
    }


    public String helloWorld() {
        return "Hello World!";
    }

    public String postMethod(){
        return "This is post method";
    }

    public String putMapping(){
        return "This is put mapping";
    }

    public String deleteMapping(){
        return "This is delete mapping";
    }

}
