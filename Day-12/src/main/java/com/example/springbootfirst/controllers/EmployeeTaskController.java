package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.EmployeeTask;
import com.example.springbootfirst.services.EmployeeTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class EmployeeTaskController {

    @Autowired
    private EmployeeTaskService taskService;

//    @PostMapping("/employee/{employeeId}")
//    public String createTask(@PathVariable int employeeId, @RequestBody EmployeeTask task) {
//        return taskService.createTask(employeeId, task);
//    }

    @PostMapping("/employee")
    public String createTask(@RequestBody EmployeeTask task) {
        return taskService.createTask(task);
    }

    @GetMapping
    public List<EmployeeTask> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/employee/{employeeId}")
    public List<EmployeeTask> getTasksByEmployee(@PathVariable int employeeId) {
        return taskService.getTasksByEmployeeId(employeeId);
    }

    @PutMapping("/{taskId}")
    public String updateTask(@PathVariable int taskId, @RequestBody EmployeeTask updatedTask) {
        return taskService.updateTask(taskId, updatedTask);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable int taskId) {
        return taskService.deleteTask(taskId);
    }
}
