package com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.dto.StudentDto;
import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.exceptions.StudentNotEligible;
import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.exceptions.StudentNullException;
import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/sendStudentDetails")
	public ResponseEntity<?> setValues(@Valid @RequestBody StudentDto studentDto) throws StudentNotEligible
	{
		return new ResponseEntity<Object>(studentService.sendDetails(studentDto),HttpStatus.CREATED);
	
		
	}
	@GetMapping("/getAllStudentsByPagination")
	public ResponseEntity<Object> getAll(@RequestParam(name = "page") Integer page,@RequestParam(name = "size") Integer size ) throws StudentNullException
	{
		return new ResponseEntity<Object>(studentService.getAll(page, size),HttpStatus.OK);
		
	}
	
//	@GetMapping("/getAllStudents")
//	public ResponseEntity<?> getAllStudents()
//	{
//		List<StudentDto> response = studentService.getAll();
//		return new ResponseEntity<List<StudentDto>>(response,HttpStatus.OK);
//		
//	}
//	


}
