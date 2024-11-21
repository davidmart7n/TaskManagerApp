package com.taskmanager.app.controller;

import com.taskmanager.app.Task;
import com.taskmanager.app.service.TaskService;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {
	
	    @Autowired
	    private TaskService taskService;
	
	    // Mostrar todas las tareas
	    @GetMapping("/tasks")
	    public String getAllTasks(Model model) {
	        model.addAttribute("tasks", taskService.getAllTasks());
	        return "tasks";  // Nombre de la plantilla HTML
	    }
	    
	
	    // Crear una nueva tarea o actualizar existente
	    @PostMapping("/tasks")
	    public String createTask(@RequestParam(required = false) Integer id,@RequestParam String name,
	    		@RequestParam String description, @RequestParam String status, @RequestParam String dueDate) {
	    	
	        Task task;
	        if (id != null) {
	            task = taskService.getTaskById(id).orElse(new Task());  /* Si id es proporcionado, 
	            														actualizamos. Si no existe, creamos una nueva.*/
	        } else {
	            task = new Task();  // Si no hay id, es una nueva tarea
	        }
	        task.setName(name);
	        task.setDescription(description);
	        task.setStatus(status);
	        task.setDueDate(LocalDate.parse(dueDate)); // Asume formato yyyy-MM-dd
	    
	        taskService.saveTask(task);
	        return "redirect:/tasks";  // Redirige a la lista de tareas después de guardar
	    }
	    
	
	    // Eliminar una tarea
	    @PostMapping("/tasks/delete")
	    public String deleteTask(@RequestParam int id) {
	        taskService.deleteTask(id);
	        return "redirect:/tasks";  // Redirige a la lista de tareas después de eliminar
	    }
	    
	 // Show the task edit form
	    @GetMapping("/editTask/{id}")
	    public String showEditTaskForm(@PathVariable("id") int taskId, Model model) {
	        Task task = taskService.getTaskById(taskId).orElse(null);
	        if (task != null) {
	            model.addAttribute("task", task);
	            return "editTask";  // Edit form
	        } else {
	            return "redirect:/tasks";  // Redirect if task not found
	        }
	    }
	    
	}
	
