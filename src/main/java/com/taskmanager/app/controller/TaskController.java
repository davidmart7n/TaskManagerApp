package com.taskmanager.app.controller;

import com.taskmanager.app.Task;
import com.taskmanager.app.Task.Status;
import com.taskmanager.app.service.TaskService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TaskController {
	
	    @Autowired
	    private TaskService taskService;
	
	    // Mostrar todas las tareas
	    @GetMapping("/tasks")
	    public String getAllTasks(Model model) {
	    	model.addAttribute("statuses", Status.values()); 
	        model.addAttribute("tasks", taskService.getAllTasks());
	        return "tasks";  // Nombre de la plantilla HTML
	    }
	    
	
	    // Crear una nueva tarea o actualizar existente
	    @PostMapping("/tasks")
	    public String createTask(@RequestParam(required = false) Integer id,@RequestParam String name,
	    		@RequestParam String description, @RequestParam Status status, @RequestParam String dueDate) {
	    	
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
	    
	    @GetMapping("/tasks/filter")
	    @ResponseBody
	    public List<Task> filterTasks(
	            @RequestParam(required = false) String name,
	            @RequestParam(required = false) String description,
	            @RequestParam(required = false) String status,
	            @RequestParam(required = false) String dueDate) {

	        List<Task> filteredTasks = taskService.getAllTasks();

	        // Filtrar por nombre
	        if (name != null && !name.isEmpty()) {
	            filteredTasks = filteredTasks.stream()
	                    .filter(task -> task.getName().toLowerCase().contains(name.toLowerCase()))
	                    .collect(Collectors.toList());
	        }

	        // Filtrar por descripción
	        if (description != null && !description.isEmpty()) {
	            filteredTasks = filteredTasks.stream()
	                    .filter(task -> task.getDescription().toLowerCase().contains(description.toLowerCase()))
	                    .collect(Collectors.toList());
	        }

	        // Filtrar por estado
	        if (status != null && !status.isEmpty()) {
	            filteredTasks = filteredTasks.stream()
	                    .filter(task -> task.getStatus().toString().equalsIgnoreCase(status))
	                    .collect(Collectors.toList());
	        }

	        // Filtrar por fecha de vencimiento
	        if (dueDate != null && !dueDate.isEmpty()) {
	            LocalDate filterDate = LocalDate.parse(dueDate);
	            filteredTasks = filteredTasks.stream()
	                    .filter(task -> task.getDueDate().equals(filterDate))
	                    .collect(Collectors.toList());
	        }

	        return filteredTasks;
	    }
	    
	}
	
