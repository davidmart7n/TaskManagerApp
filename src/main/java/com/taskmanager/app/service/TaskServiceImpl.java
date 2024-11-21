package com.taskmanager.app.service;

import com.taskmanager.app.Task;
import com.taskmanager.app.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    // Crear o actualizar una tarea
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    // Obtener todas las tareas
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Obtener una tarea por ID
    public Optional<Task> getTaskById(int id) {
        return taskRepository.findById(id);
    }

    // Eliminar una tarea por ID
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}
