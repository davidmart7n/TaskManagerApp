package com.taskmanager.app.apirest;

import com.taskmanager.app.Task;
import com.taskmanager.app.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskApiController {

    @Autowired
    private TaskService taskService;

    // Obtener todas las tareas
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Crear una nueva tarea
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    // Obtener una tarea por ID
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable int id) {
        return taskService.getTaskById(id);
    }

    // Actualizar una tarea
    @PutMapping("/{id}")
    public Task updateTask( @RequestBody Task task) {
        return taskService.saveTask(task);
    }

    // Eliminar una tarea
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
    }
}
