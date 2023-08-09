package com.spring.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.models.User;
import com.spring.app.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> getUsers(){
		return repository.findAll();
	}
	
	public User getUserById(int id) {
		return repository.findById(id).get();
	}
	
	public User addUser(User user) {
		return repository.save(user);
	}
	
	public void deleteUser(int id) {
		this.repository.deleteById(id);
	}
	
}
