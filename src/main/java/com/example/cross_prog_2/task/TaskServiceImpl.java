package com.example.cross_prog_2.task;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(CreateTaskParameters createTaskParameters) {
        UUID taskId = UUID.randomUUID();
        var task = new Task(
                new TaskId(taskId),
                createTaskParameters.getTask(),
                createTaskParameters.isImportant(),
                createTaskParameters.isChecked(),
                createTaskParameters.getDate()
        );
        Task savedTask = taskRepository.save(task);
        System.out.println("Saved task: " + savedTask);
        return savedTask;
    }

    @Override
    public Page<Task> getTasks(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }


    @Override
    public void deleteTask(TaskId id) {
        if (!taskRepository.existsById(id)) {
            throw new NoSuchElementException("Task not found");
        }
        taskRepository.deleteById(id);
    }

    @Override
    public Task getTaskById(TaskId id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Task updateTask(TaskId taskId, EditTaskParameters editTaskParameters) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new NoSuchElementException("Task not found"));

        if (editTaskParameters.getVersion() != task.getVersion()) {
            throw new ObjectOptimisticLockingFailureException(Task.class, task.getId().asString());
        }

        editTaskParameters.update(task);

        return task;
    }
}
