package com.example.Tasker.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    private int ID;
    private String title;
    private String Description;
    private String dailyTiming;
    private LocalDate date;
    private Boolean isCompleted;
}
