package com.example.demosp.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demosp.domain.Student;
import com.example.demosp.service.StudentService;

@RequestMapping(path="/api/v1/students")
@RestController
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping(path = {"","/"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getStudents(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		return studentService.getStudents(PageRequest.of(page, size));
	}

	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Student>> getAllStudents() {
		return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);

	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> getStudent(@PathVariable Long id) {
		Student student = studentService.findById(id);
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}

	@PostMapping(path = {"","/"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {
		return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student, @PathVariable Long id) {
		Student oldStudent = studentService.findById(id);
		oldStudent.setFirstName(student.getFirstName());
		oldStudent.setLastName(student.getLastName());
		oldStudent.setAddress(student.getAddress());
		oldStudent.setRut(student.getRut());
		return new ResponseEntity<>(studentService.save(oldStudent), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> delete(@PathVariable Long id) {
		Student oldStudent = studentService.findById(id);
		studentService.delete(id);
		return new ResponseEntity<>(oldStudent, HttpStatus.OK);
	}
}
