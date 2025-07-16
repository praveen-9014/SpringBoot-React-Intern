package com.example.springbootfirst.services;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.models.Roles;
import com.example.springbootfirst.models.UserDetailsDto;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import com.example.springbootfirst.repository.RolesRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @Mock
    RegisterDetailsRepository registerRepo;

    @Mock
    RolesRepo rolesRepo;

    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    EmployeeService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    // 23AD102

    @Test
    void testGetAllEmployees() {
        when(registerRepo.findAll()).thenReturn(Arrays.asList(new RegisterDetails(), new RegisterDetails()));
        assertEquals(2, service.getMethod().size());
    }

    @Test
    void testGetEmployeeById() {
        RegisterDetails emp = new RegisterDetails();
        emp.setEmpId(1);
        when(registerRepo.findById(1)).thenReturn(Optional.of(emp));
        assertEquals(1, service.getEmployeeById(1).getEmpId());
    }

    @Test
    void testAddNewEmployee() {
        UserDetailsDto dto = new UserDetailsDto();
        dto.setEmpId(1);
        dto.setName("test");
        dto.setEmail("email");
        dto.setPassword("pass");
        dto.setUsername("user");
        dto.setRoleNames((Set<String>) List.of("ROLE_USER"));

        Roles role = new Roles();
        role.setRoleName("ROLE_USER");

        when(passwordEncoder.encode("pass")).thenReturn("hashed");
        when(rolesRepo.findByRoleName("ROLE_USER")).thenReturn(Optional.of(role));

        assertEquals("Employee Added Successfully", service.addNewEmployee(dto));
    }

    @Test
    void testUpdateEmployee() {
        RegisterDetails emp = new RegisterDetails();
        when(registerRepo.findById(1)).thenReturn(Optional.of(emp));
        assertEquals("Employee Updated Successfully", service.updateEmployee(1));
    }

    @Test
    void testDeleteEmployeeById() {
        assertEquals("Employee Deleted Successfully", service.deleteEmployeeById(1));
    }
}
