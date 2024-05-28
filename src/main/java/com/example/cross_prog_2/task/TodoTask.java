package com.example.cross_prog_2.task;

import jakarta.persistence.Embeddable;

@Embeddable
public class TodoTask {
    private String task;

    public TodoTask(String task) {
        this.task = task;
    }

    public TodoTask() {

    }

    public String getTask() {
        return task;
    }
}
