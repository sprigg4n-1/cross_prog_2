package com.example.cross_prog_2.task;

public class EditTaskFormData extends CreateTaskFormData {
    private String id;
    private long version;

    public static EditTaskFormData fromTask(Task task) {
        EditTaskFormData res = new EditTaskFormData();
        res.setId(task.getId().asString());
        res.setTask(task.getTodoTask().getTask());
        res.setImportant(task.isImportant());
        res.setChecked(task.isChecked());
        res.setDate(task.getDate());
        return res;
    }

    public EditTaskParameters toParameters() {
        return new EditTaskParameters(getVersion(), new TodoTask(getTask()), isImportant(), isChecked(), getDate());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
