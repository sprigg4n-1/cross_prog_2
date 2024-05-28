package com.example.cross_prog_2.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class CreateTaskFormData {
    @NotBlank
    private String task;

    @NotNull
    private boolean important;

    @NotNull
    private boolean checked;

    @NotNull
    private LocalDateTime date;


    public @NotBlank String getTask() {
        return task;
    }

    @NotNull
    public boolean isImportant() {
        return important;
    }

    @NotNull
    public boolean isChecked() {
        return checked;
    }

    public @NotNull LocalDateTime getDate() {
        return date;
    }

    public CreateTaskParameters toParameters() {
        return new CreateTaskParameters(new TodoTask(task), important, checked, date);
    }

    public void setTask(@NotBlank String task) {
        this.task = task;
    }

    public void setImportant(@NotNull boolean important) {
        this.important = important;
    }

    public void setChecked(@NotNull boolean checked) {
        this.checked = checked;
    }

    public void setDate(@NotNull LocalDateTime date) {
        this.date = date;
    }
}
