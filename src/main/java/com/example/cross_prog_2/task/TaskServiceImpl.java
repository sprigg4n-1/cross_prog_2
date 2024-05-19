package com.example.cross_prog_2.task;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(CreateTaskParameters createTaskParameters) {
        TaskId taskId = taskRepository.nextId();

        var task = new Task(
                taskId,
                createTaskParameters.task(),
                createTaskParameters.important(),
                createTaskParameters.checked(),
                createTaskParameters.date()
        );
        Task savedTask = taskRepository.save(task);
        System.out.println("Saved task: " + savedTask);
        return savedTask;
    }

    @Override
    public Page<Task> getTasks(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }
}
