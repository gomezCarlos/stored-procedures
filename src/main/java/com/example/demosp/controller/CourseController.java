package com.example.demosp.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demosp.domain.Course;
import com.example.demosp.domain.Student;
import com.example.demosp.service.CourseService;
import com.example.demosp.service.StudentService;

@RestController
public class CourseController {

	private CourseService courseService;

	private StudentService studentService;

	public CourseController(CourseService courseService, StudentService studentService) {
		this.courseService = courseService;
		this.studentService = studentService;
	}

	@PostMapping(path = "/courses",consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
		return new ResponseEntity<>(courseService.save(course), HttpStatus.CREATED);
	}

	@GetMapping(path = "courses/{id}/{studentId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> addStudent(@PathVariable Long id, @PathVariable Long studentId) {
		Course course = courseService.findById(id);

		Student student = studentService.findById(studentId);
		course.getStudents().add(student);
		courseService.save(course);

		return new ResponseEntity<>(course, HttpStatus.OK);
	}

	@GetMapping(path = "/courses/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> getCourse(@PathVariable Long id) {
		Course oldCourse = courseService.findById(id);
		return new ResponseEntity<>(oldCourse, HttpStatus.OK);
	}

	@PutMapping(path = "/courses/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
		Course oldCourse = courseService.findById(id);
		oldCourse.setCode(course.getCode());
		oldCourse.setName(course.getName());
		return new ResponseEntity<>(courseService.save(oldCourse), HttpStatus.OK);
	}

	@GetMapping(path = "/courses", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Course>> getPaginatedCourses(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		Page<Course> pageable = courseService.getCourses(PageRequest.of(page, size));
		return new ResponseEntity<>(pageable, HttpStatus.OK);
	}

	@GetMapping(path = "/courses/all", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Course> getAllCourses() {
		return courseService.findAll();
	}

	@GetMapping(path = "/courses/empty", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Course> getEmptyCourses() {
		List<Course> result = courseService.findEmptyCourses();
		return result;
	}

	@DeleteMapping(path = "/courses/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> deleteCourse(Long id) {
		Course oldCourse = courseService.findById(id);
		courseService.delete(id);
		return new ResponseEntity<>(oldCourse, HttpStatus.OK);
	}

}
