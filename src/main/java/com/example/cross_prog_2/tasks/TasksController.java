package com.example.cross_prog_2.tasks;

import org.springframework.ui.Model;
import com.example.cross_prog_2.task.TaskService;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.data.domain.Pageable;

@Controller
@RequestMapping("/tasks")
public class TasksController {

    private final TaskService taskService;

    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String tasks(Model model, Pageable pageable)  {
        model.addAttribute("title", "Task");
        model.addAttribute("tasks", taskService.getTasks(pageable));

        return "tasks/list";
    }
}
