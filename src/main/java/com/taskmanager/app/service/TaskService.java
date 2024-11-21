package com.taskmanager.app.service;

import java.util.List;
import java.util.Optional;

import com.taskmanager.app.Task;

public interface TaskService {
	
	public Task saveTask(Task task);
	
	public List<Task> getAllTasks();
	
	public Optional<Task> getTaskById(int id) ;
	
	public void deleteTask(int id);

}
