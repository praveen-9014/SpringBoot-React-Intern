package com.example.Tasker.services;

import com.example.Tasker.models.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TaskService {

    List<Task> taskList = new ArrayList<>(
            Arrays.asList(
                    new Task(1, "Morning Workout", "30 minutes cardio + 20 minutes strength", "5:00 AM - 6:30 AM", LocalDate.now(), false),
                    new Task(2, "DSA Practice", "Solve 5 problems on Leetcode", "7:00 PM - 8:00 PM", LocalDate.now(), false)
            )
    );

    public List<Task> getTask(){
        return taskList;
    }

    public String addTask(Task task){
        taskList.add(task);
        return "Task is added sucessfully";
    }


    public String updateTask(Task task){
        int ind = 0;
        boolean flag = false;
        for(int i=0;i<taskList.size();i++){
            if(task.getID() == taskList.get(i).getID()){
                ind = i;
                flag = true;
                break;
            }
        }

        if(flag){
            taskList.set(ind, task);
            return "task is updated sucessfully";
        }
        else{
            return "Enter the correct task Id";
        }
    }

    public String deleteTask(int id){
        int ind = 0;
        boolean flag = false;
        for(int i=0;i<taskList.size();i++){
            if(id == taskList.get(i).getID()){
                ind = i;
                flag = true;
                break;
            }
        }

        if(flag){
            taskList.remove(ind);
            return "The task is deleted";
        }
        else{
            return "Enter the correct task ID";
        }
    }
}
