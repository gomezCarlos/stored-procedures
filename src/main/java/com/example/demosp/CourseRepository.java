package com.example.demosp;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.query.Procedure;

@Repository
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {

@Procedure(name="findEmptyCourses")
List<Course>  findEmptyCourses();

}
