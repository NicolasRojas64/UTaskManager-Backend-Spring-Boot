package com.spring.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.models.Task;
import com.spring.app.repositories.TaskRepository;

@Service
public class TaskService{
	
	@Autowired
	private TaskRepository taskRepository;
	
	public Task addTask(Task task) {
		return taskRepository.save(task);
	}
	
	public Task findTaskById(int id) {
		return taskRepository.findById(id).get();
	}
	
	public String deleteTask(int id) {
		this.taskRepository.deleteById(id);
		return "Asignatura eliminada";
	}
}
