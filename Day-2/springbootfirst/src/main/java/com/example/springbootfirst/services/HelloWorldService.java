package com.example.springbootfirst.services;

import com.example.springbootfirst.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {

    List<Employee> emp = new ArrayList<>(
            Arrays.asList(new Employee(1, "praveen", "developer"), new Employee(2, "jack", "Tester"))
    );


    public List<Employee> getMethod(){
        return emp;
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
