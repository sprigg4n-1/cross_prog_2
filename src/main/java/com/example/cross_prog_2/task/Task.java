package com.example.cross_prog_2.task;

import io.github.wimdeblauwe.jpearl.AbstractEntity;
import io.github.wimdeblauwe.jpearl.AbstractVersionedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "tt_tasks")
public class Task extends AbstractVersionedEntity<TaskId> {

    @NotNull
    private TodoTask todoTask;

    @NotNull
    private boolean important;

    @NotNull
    private boolean checked;

    @NotNull
    private LocalDateTime date;

    public Task() {
    }

    public Task(TaskId id, TodoTask todoTask, boolean important, boolean checked, LocalDateTime date) {
        super(id);
        this.todoTask = todoTask;
        this.important = important;
        this.checked = checked;
        this.date = date;
    }


    public boolean isImportant() {
        return important;
    }

    public void setImportant( boolean important) {
        this.important = important;
    }


    public boolean isChecked() {
        return checked;
    }

    public void setChecked( boolean checked) {
        this.checked = checked;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate( LocalDateTime date) {
        this.date = date;
    }

    public TodoTask getTodoTask() {
        return todoTask;
    }

    public void setTodoTask( TodoTask todoTask) {
        this.todoTask = todoTask;
    }
}
