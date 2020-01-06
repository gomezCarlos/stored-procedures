package com.example.demosp;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface CourseService {

	Course findById(Long id);

	Course save(Course course);
	
	List<Course> findAll();

	void delete(Long id);

	Page<Course> getCourses(Pageable pageable);

	List<Course> findEmptyCourses();
}
