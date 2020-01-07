package com.example.demosp.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demosp.domain.Course;

@Repository
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {

@Procedure(name="findEmptyCourses")
Object  findEmptyCourses();

}
