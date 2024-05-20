package com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.service;

import java.util.List;

import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.dto.StudentDto;
import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.exceptions.StudentNotEligible;
import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.exceptions.StudentNullException;

public interface StudentService {
	
	
	public Object sendDetails(StudentDto studentDto) throws StudentNotEligible;
	//public Object sendEmail(StudentDto studentDto);
	//public List<StudentDto> getAll();
	public Object getAll(Integer page,Integer size) throws StudentNullException;
	

}
