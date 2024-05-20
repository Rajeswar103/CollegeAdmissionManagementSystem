package com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.dto.AdminDto;
import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.service.AdminService;

@RestController
public class AdminController {

	
	@Autowired
	private AdminService service;
	
	@PostMapping("/sendCredentails")
	public ResponseEntity<Object> setValues(@RequestBody AdminDto adminDto)
	{
		return new ResponseEntity<Object>(service.setValues(adminDto),HttpStatus.CREATED);
		
	}
}
