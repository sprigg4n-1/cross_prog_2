package com.example.cross_prog_2;

import com.example.cross_prog_2.task.CreateTaskParameters;
import com.example.cross_prog_2.task.TaskService;
import com.example.cross_prog_2.task.TodoTask;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
@Profile("init-db")
public class DataBaseInitializer implements CommandLineRunner {
    private final Faker faker = new Faker();
    private final TaskService taskService;

    public DataBaseInitializer(TaskService taskService) {
        this.taskService = taskService;
    }


    @Override
    public void run(String... args) {
        for (int i = 0; i < 20; i++) {
            CreateTaskParameters task = CreateTask();
            taskService.createTask(task);
            System.out.println("Created task: " + task);

        }
    }

    private CreateTaskParameters CreateTask() {
        String task = faker.name().name();
        boolean important = faker.bool().bool();
        boolean checked = faker.bool().bool();
        LocalDateTime date = LocalDateTime.ofInstant(faker.date().birthday().toInstant(), ZoneId.systemDefault());

        return new CreateTaskParameters(new TodoTask(task), important, checked, date);
    }
}
