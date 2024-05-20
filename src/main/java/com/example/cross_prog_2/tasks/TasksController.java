package com.example.cross_prog_2.tasks;

import com.example.cross_prog_2.task.CreateTaskParameters;
import com.example.cross_prog_2.task.Task;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import com.example.cross_prog_2.task.TaskService;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
        model.addAttribute("task", new Task());
        return "tasks/list";
    }

    @PostMapping
    public String createTask(@Valid @ModelAttribute("task") Task task, BindingResult result, Model model, Pageable pageable) {
        if (result.hasErrors()) {
            model.addAttribute("title", "Tasks");
            model.addAttribute("tasks", taskService.getTasks(pageable));
            return "tasks/list";
        }
        CreateTaskParameters createTaskParameters = new CreateTaskParameters(
                task.getTask(),
                task.isImportant(),
                task.isChecked(),
                task.getDate()
        );
        taskService.createTask(createTaskParameters);
        return "redirect:/tasks";
    }
}
