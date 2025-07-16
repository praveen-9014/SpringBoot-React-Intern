package com.example.springbootfirst.services;

import com.example.springbootfirst.models.EmployeeTask;
import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.repository.EmployeeTaskRepository;
import com.example.springbootfirst.repository.RegisterDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeTaskService {

    @Autowired
    private EmployeeTaskRepository taskRepository;

    @Autowired
    private RegisterDetailsRepo registerRepo;

    public EmployeeTask createTask(int employeeId, EmployeeTask task) {
        RegisterDetails employee = registerRepo.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        task.setEmployee(employee);
        return taskRepository.save(task);
    }

    public List<EmployeeTask> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<EmployeeTask> getTasksByEmployeeId(int employeeId) {
        return taskRepository.findByEmployeeEmpId(employeeId);
    }
}
