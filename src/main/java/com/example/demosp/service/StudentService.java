package com.example.demosp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demosp.domain.Student;

import java.util.List;

public interface StudentService {
	
	Page<Student> getStudents(Pageable pageable);

	Student save(Student student);
	
	void delete(Long id);

	Student findById(Long id);

	List<Student> findAll();

}
