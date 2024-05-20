package com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.globalexception;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.exceptions.StudentNotEligible;
import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.exceptions.StudentNullException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptions {
	
	
	
	@ExceptionHandler(StudentNotEligible.class)
	public ResponseEntity<?> handleUserDefinedExpections(StudentNotEligible e)
	{
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<String,String>> handleConstraintViolationException(ConstraintViolationException e)
	{
		
		Set<ConstraintViolation<?>> c=e.getConstraintViolations();
		Map<String,String> mapResults=new HashMap<>();
		
		for(ConstraintViolation<?> e1:c)
		{
			String s1=e1.getPropertyPath().toString();
			String s2=e1.getMessage();
			mapResults.put(s1, s2);
		}
		return new ResponseEntity<Map<String,String>>(mapResults,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(StudentNullException.class)
	public ResponseEntity<?> handleStudentNullException(StudentNullException s)
	{
		return new ResponseEntity<String>(s.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
}
