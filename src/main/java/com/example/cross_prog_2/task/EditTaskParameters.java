package com.example.cross_prog_2.task;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

public class EditTaskParameters extends CreateTaskParameters {

    private long version;

    public EditTaskParameters(long version, TodoTask task, boolean important, boolean checked, LocalDateTime date) {
        super(task, important, checked, date);
        this.version = version;
    }

    public long getVersion() {
        return version;
    }


    public void update(Task task) {
        task.setTodoTask(getTask());
        task.setImportant(isImportant());
        task.setChecked(isChecked());
        task.setDate(getDate());
    }

}
