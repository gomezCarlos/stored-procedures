package com.example.demosp.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.demosp.domain.Course;

import org.springframework.data.domain.Page;

public interface CourseService {

	Course findById(Long id);

	Course save(Course course);
	
	List<Course> findAll();

	void delete(Long id);

	Page<Course> getCourses(Pageable pageable);

	List<Course> findEmptyCourses();
}
