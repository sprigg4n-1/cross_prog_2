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

    public Task() {
    }

    public Task(TaskId id, String task, boolean important, boolean checked, LocalDateTime date) {
        super(id);
        this.task = task;
        this.important = important;
        this.checked = checked;
        this.date = date;
    }

    public @NotNull String getTask() {
        return task;
    }

    public void setTask(@NotNull String task) {
        this.task = task;
    }

    @NotNull
    public boolean isImportant() {
        return important;
    }

    public void setImportant(@NotNull boolean important) {
        this.important = important;
    }

    @NotNull
    public boolean isChecked() {
        return checked;
    }

    public void setChecked(@NotNull boolean checked) {
        this.checked = checked;
    }

    public @NotNull LocalDateTime getDate() {
        return date;
    }

    public void setDate(@NotNull LocalDateTime date) {
        this.date = date;
    }
}
