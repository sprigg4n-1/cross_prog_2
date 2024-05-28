package com.example.cross_prog_2.task;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {
    Task createTask(CreateTaskParameters createTaskParameters);
    Page<Task> getTasks(Pageable pageable);
    void deleteTask(TaskId id);
    Task getTaskById(TaskId id);
    Task updateTask(TaskId taskId, EditTaskParameters editTaskParameters);
}
