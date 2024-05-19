package com.example.cross_prog_2.task;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {
    Task createTask(CreateTaskParameters createTaskParameters);
    Page<Task> getTasks(Pageable pageable);
}
