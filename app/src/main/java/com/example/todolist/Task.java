package com.example.todolist;

public class Task {

    String taskName;
    int taskMonth;
    int taskDay;

    public Task(String name, int month, int day) {
        taskName = name;
        taskMonth = month;
        taskDay = day;
    }

    public String getName () {
        return taskName;
    }
}
