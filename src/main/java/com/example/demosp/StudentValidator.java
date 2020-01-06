package com.example.demosp;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Student.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "rut","empty rut");
		Student student = (Student)target;
		if(student.getRut().length()<9)
			errors.rejectValue("rut", "rut too short");
	}

}
