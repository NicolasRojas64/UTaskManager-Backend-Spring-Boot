package com.spring.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/all")
	public List<Subject> getAllSubjects(){
		return this.subjectsService.getSubjects();
	}
	
	@PostMapping("/{id}")
	public Subject addSubject(@RequestBody Subject subject, @PathVariable int id) {
		User user = userService.getUserById(id);
		subject.setUser(user);
		return this.subjectsService.addSubject(subject);
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
	
}
