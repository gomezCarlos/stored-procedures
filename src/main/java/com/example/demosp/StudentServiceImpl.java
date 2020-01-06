package com.example.demosp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@Primary
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Page<Student> getStudents(Pageable pageable) {
		return studentRepository.findAll(pageable);
	}

	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void delete(Long id) {
		studentRepository.deleteById(id);
		
	}

	@Override
	public Student findById(Long id) {
		Student student = studentRepository.findById(id).orElse(null);
		if(null == student)
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
