package com.example.demosp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Loggable {

	Logger LOGGER = LoggerFactory.getLogger(Loggable.class);
	
	@AfterReturning(pointcut="execution(* com.example.demosp.*.*.*(..))",returning="value")
	public void logReturn(JoinPoint jp, Object value) {
		LOGGER.info("Class {} executed action: {} with returning value of: {}",jp.getSignature().getDeclaringTypeName() , jp.getSignature().getName(),value);
	}
}
