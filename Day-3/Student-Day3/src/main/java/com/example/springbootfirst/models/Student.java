package com.example.springbootfirst.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int rollNumber;
    private String name;
    private int age;
    private String mobileNumber;

}
