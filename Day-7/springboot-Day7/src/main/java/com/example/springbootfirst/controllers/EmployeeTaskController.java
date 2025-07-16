package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.EmployeeTask;
import com.example.springbootfirst.services.EmployeeTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class EmployeeTaskController {

    @Autowired
    private EmployeeTaskService taskService;

    // Create task for a specific employee
    @PostMapping("/employee/{employeeId}")
    public EmployeeTask createTask(@PathVariable int employeeId, @RequestBody EmployeeTask task) {
        return taskService.createTask(employeeId, task);
    }

    // Get all tasks
    @GetMapping
    public List<EmployeeTask> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Get tasks by employee
    @GetMapping("/employee/{employeeId}")
    public List<EmployeeTask> getTasksByEmployee(@PathVariable int employeeId) {
        return taskService.getTasksByEmployeeId(employeeId);
    }
}
