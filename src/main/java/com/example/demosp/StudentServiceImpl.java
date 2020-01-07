package com.example.demosp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	public Page<Student> getStudents(Pageable pageable) {
		return studentRepository.findAll(pageable);
	}

	@Transactional
	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		studentRepository.deleteById(id);

	}

	@Override
	public Student findById(Long id) {
		Student student = studentRepository.findById(id).orElse(null);
		if (null == student)
			throw new NotFoundException();
		return student;
	}

	@Override
	public List<Student> findAll() {
		List<Student> students = new ArrayList<>();
		studentRepository.findAll().forEach(students::add);
		return students;
	}

}
