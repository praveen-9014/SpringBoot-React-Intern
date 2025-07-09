package com.example.springbootfirst.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // set of data that hold all field is called entity and if one entity means there is one id
public class Employee {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empIdl;
    private String name;
    private String job;



}
