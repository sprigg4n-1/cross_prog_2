package com.example.cross_prog_2.tasks;

import com.example.cross_prog_2.task.*;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.NoSuchElementException;

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
        model.addAttribute("task", new CreateTeamFormData());
        return "tasks/list";
    }

    @PostMapping
    public String createTask(@Valid @ModelAttribute("task") CreateTeamFormData formData, BindingResult result, Model model, Pageable pageable) {
        if (result.hasErrors()) {
            model.addAttribute("title", "Tasks");
            model.addAttribute("tasks", taskService.getTasks(pageable));
            return "tasks/list";
        }

        taskService.createTask(formData.toParameters());
        return "redirect:/tasks";
    }


    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") TaskId id, RedirectAttributes redirectAttributes) {
        try {
            taskService.deleteTask(id);
            redirectAttributes.addFlashAttribute("successMessage", "Task successfully deleted.");
        } catch (NoSuchElementException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Task not found.");
        }
        return "redirect:/tasks";
    }
}
