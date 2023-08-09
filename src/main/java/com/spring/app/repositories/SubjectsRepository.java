package com.spring.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.app.models.Subject;

@Repository
public interface SubjectsRepository extends JpaRepository<Subject, Integer>{

}
