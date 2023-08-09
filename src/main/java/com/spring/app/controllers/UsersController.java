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
import com.spring.app.models.User;
import com.spring.app.services.UserService;

@RestController
@RequestMapping("/")
public class UsersController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("users")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@PostMapping("user")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@GetMapping("/user/subjects/{id}")
	public List<Subject> getUserSubjects(@PathVariable int id){
		List<Subject> subjects = userService.getUserById(id).getSubjects();
		return  subjects;
	}
	
	@PutMapping("user/{id}")
	public User updateUser(@RequestBody User newUser, @PathVariable int id) {
		User user = this.userService.getUserById(id);
		user.setUser_name(newUser.getUser_name());
		user.setPassword(newUser.getPassword());
		return this.userService.addUser(user);
	}
	
	@DeleteMapping("user/{id}")
	public String deleteUser(@PathVariable int id) {
		this.userService.deleteUser(id);
		return "Usuario eliminado";
	}
	
}
