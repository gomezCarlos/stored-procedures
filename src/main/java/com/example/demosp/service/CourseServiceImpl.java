package com.example.demosp.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demosp.component.NotFoundException;
import com.example.demosp.domain.Course;
import com.example.demosp.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	
	private CourseRepository courseRepository;
	private EntityManager entityManager;
	
	public CourseServiceImpl(CourseRepository courseRepository, EntityManager entityManager) {
		this.courseRepository = courseRepository;
		this.entityManager = entityManager;
	}
	
	@Override
	public Course findById(Long id) {
		
		return courseRepository.findById(id).orElseThrow(() -> 
		new NotFoundException());
	}

	@Transactional
	@Override
	public Course save(Course course) {
		
		return courseRepository.save(course);
	}
	
	@Transactional
	@Override
	public void delete(Long id) {
		courseRepository.deleteById(id);
	}

	@Override
	public List<Course> findAll() {
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
	}

	@Override
	public Page<Course> getCourses(Pageable pageable) {
		
		return courseRepository.findAll(pageable);
	}

	@Transactional
	@Override
	public List<Course> findEmptyCourses(){
		
		StoredProcedureQuery query = entityManager
				.createStoredProcedureQuery("fetch_empty_courses")
				.registerStoredProcedureParameter(
				    1,
				    void.class,
				    ParameterMode.REF_CURSOR
				);
				 
				@SuppressWarnings("unchecked")
				List<Course> resultList = query.getResultList();
				return resultList;
	}
}
