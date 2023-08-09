package com.spring.app.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.app.models.Subject;
import com.spring.app.repositories.SubjectsRepository;

@Service
public class SubjectsService {
	
	@Autowired
	private SubjectsRepository subjectsRepository;
	
	public List<Subject> getSubjects() {
		return subjectsRepository.findAll();
	}
	
	public Subject addSubject(Subject subject) {
		return subjectsRepository.save(subject);
	}
	
	public Subject getSubjectById(int id) {
		return subjectsRepository.findById(id).get();
	}
}
