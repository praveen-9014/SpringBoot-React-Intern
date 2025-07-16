package com.example.Tasker.controllers;

import com.example.Tasker.models.Task;
import com.example.Tasker.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService ts;


    @GetMapping
    public List<Task> getTask(){
        return ts.getTask();
    }


    @PostMapping
    public String addTaks(@RequestBody Task task){
        return ts.addTask(task);
    }


    @PutMapping
    public String updateTask(@RequestBody Task task){
        return ts.updateTask(task);
    }


    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id){
        return ts.deleteTask(id);
    }

}
