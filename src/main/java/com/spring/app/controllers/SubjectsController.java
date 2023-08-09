package com.spring.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.app.models.Subject;
import com.spring.app.models.Task;
import com.spring.app.models.User;
import com.spring.app.services.SubjectsService;
import com.spring.app.services.TaskService;
import com.spring.app.services.UserService;

@RestController
@RequestMapping("/subject")
public class SubjectsController {

	@Autowired
	private SubjectsService subjectsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping("/{id}")
	public Subject addSubject(@RequestBody Subject subject, @PathVariable int id) {
		User user = userService.getUserById(id);
		subject.setUser(user);
		return this.subjectsService.addSubject(subject);
	}
	
	@PutMapping("/{id}")
	public Subject modifySubject(@RequestBody Subject newSubject, @PathVariable int id){
		Subject subject = this.subjectsService.getSubjectById(id);
		subject.setSubject_name(newSubject.getSubject_name());
		return this.subjectsService.addSubject(subject);
	}
	
	@DeleteMapping("/{id}")
	public String deleteSubject(@PathVariable int id) {
		return this.subjectsService.deleteSubject(id);
	}
	
	@PostMapping("/task/{id}")
	public Task addTask(@RequestBody Task task,@PathVariable int id) {
		Subject subject = subjectsService.getSubjectById(id);
		task.setSubject(subject);
		return this.taskService.addTask(task);
	}
	
	@GetMapping("/tasks/{id}")
	public List<Task> getTasks(@PathVariable int id){
		Subject subject = subjectsService.getSubjectById(id);
		return subject.getTasks();
	}
	
	@PutMapping("/task/{id}")
	public Task modifyTask(@PathVariable int id, @RequestBody Task newTask) {
		Task task = this.taskService.findTaskById(id);
		task.setTask_name(newTask.getTask_name());
		task.setTask_description(newTask.getTask_description());
		task.setLimit_date(newTask.getLimit_date());
		return this.taskService.addTask(task);
	}
	
	@DeleteMapping("/task/{id}")
	public String deleteTask(@PathVariable int id) {
		return this.taskService.deleteTask(id);
	}
	
	
	
}
