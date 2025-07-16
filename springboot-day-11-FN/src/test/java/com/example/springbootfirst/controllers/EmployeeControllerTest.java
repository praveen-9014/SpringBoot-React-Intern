package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.models.UserDetailsDto;
import com.example.springbootfirst.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeControllerTest {

    //    23AD102

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRoute() {
        String response = employeeController.route();
        assertEquals("Welcome to SpringBoot Security", response);
    }

    @Test
    void testGetMethod() {
        RegisterDetails emp1 = new RegisterDetails();
        RegisterDetails emp2 = new RegisterDetails();
        when(employeeService.getMethod()).thenReturn(Arrays.asList(emp1, emp2));

        List<RegisterDetails> result = employeeController.getMethod();
        assertEquals(2, result.size());
    }

    @Test
    void testGetEmployeeById() {
        RegisterDetails emp = new RegisterDetails();
        when(employeeService.getEmployeeById(1)).thenReturn(emp);

        RegisterDetails result = employeeController.getEmployeeById(1);
        assertEquals(emp, result);
    }

    // 23Ad102

    @Test
    void testPostMethod() {
        UserDetailsDto dto = new UserDetailsDto();
        when(employeeService.addNewEmployee(dto)).thenReturn("Employee added");

        String response = employeeController.postMethod(dto);
        assertEquals("Employee added", response);
    }

    @Test
    void testPutMethod() {
        when(employeeService.updateEmployee(10)).thenReturn("Updated");

        String result = employeeController.putMethod(10);
        assertEquals("Updated", result);
    }

    @Test
    void testDeleteMethod() {
        when(employeeService.deleteEmployeeById(15)).thenReturn("Deleted");

        String result = employeeController.deleteMethod(15);
        assertEquals("Deleted", result);
    }
}
