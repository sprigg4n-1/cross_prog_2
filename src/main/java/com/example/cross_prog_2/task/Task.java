package com.example.cross_prog_2.task;

import io.github.wimdeblauwe.jpearl.AbstractEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "tt_tasks")
public class Task extends AbstractEntity<TaskId> {

    @NotNull
    private String task;

    @NotNull
    private boolean important;

    @NotNull
    private boolean checked;

    @NotNull
    private LocalDateTime date;


    protected Task() {
    }

    public Task(TaskId id, String task, boolean important, boolean checked, LocalDateTime date) {
        super(id);
        this.task = task;
        this.important = important;
        this.checked = checked;
        this.date = date;
    }

    public @NotNull LocalDateTime getDate() {
        return date;
    }

    @NotNull
    public boolean isChecked() {
        return checked;
    }

    @NotNull
    public boolean isImportant() {
        return important;
    }

    public @NotNull String getTask() {
        return task;
    }
}