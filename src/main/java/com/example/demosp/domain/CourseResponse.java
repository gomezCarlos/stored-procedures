package com.example.demosp.domain;

import java.util.List;
import java.util.ArrayList;

public class CourseResponse {
	
	List<Course> emptyCourses = new ArrayList<>();

	public List<Course> getEmptyCourses() {
		return emptyCourses;
	}

	public void setEmptyCourses(List<Course> courses) {
		this.emptyCourses = courses;
	}

}
