package com.taskmanager.app.homeController;

import com.taskmanager.app.Task;
import com.taskmanager.app.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    private TaskService taskService;

    // Redirige a la vista de inicio (index.html)
    @GetMapping("/")
    public String showHomePage() {
        return "index";  // Redirige a la vista "index.html"
    }

    // Mostrar formulario para crear una nueva tarea
    @GetMapping("/createTask")
    public String showCreateTaskForm(Model model) {
        model.addAttribute("statuses", Task.Status.values());  // Enviar los estados disponibles al formulario
        return "createTask";  // Vista donde se crea la tarea
    }

    // Mostrar formulario de edición de tarea
    @GetMapping("/editTask/{id}")
    public String showEditTaskForm(@PathVariable("id") int taskId, Model model) {
        Task task = taskService.getTaskById(taskId).orElse(null);
        if (task != null) {
            model.addAttribute("task", task);
            return "editTask";  // Vista para editar la tarea
        } else {
            return "redirect:/tasks";  // Redirige a la lista si la tarea no se encuentra
        }
    }
    // Mostrar detalles del proyecto
    @GetMapping("/details")
    public String showProjectDetails() {
        return "details";  // Retorna la vista "details.html"
    }
}

