package com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.dao.StudentRepository;
import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.dto.StudentDto;
import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.exceptions.StudentNotEligible;
import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.exceptions.StudentNullException;
import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.model.Student;
import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository Studentrepo;
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public Object sendDetails(StudentDto studentDto) throws StudentNotEligible {
		
		

		Student student = mappingToEntity(studentDto);
		if(student.getIntermiadateMarks()<70)
		{
			throw new StudentNotEligible();
		}
		Student response = Studentrepo.save(student);
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setFrom("rajeswarb.in@mouritech.com");
		mailMessage.setSubject("your Personal Details along with AdmissionNumber");
		mailMessage.setTo(response.getEmail());
		mailMessage.setText("firstName :"+response.getFirstName()+"\n"+"lastName :"+response.getLastName()+"\n"+
				"fatherName :"+response.getFatherName()+"\n"+"motherName :"+response.getMotherName()+"\n"+
				"mobileNumber :"+response.getMobileNumber()+"\n"+"Intermidiate Percentage :"+Integer.toString(response.getIntermiadateMarks())+"\n"+
				"Admission ID :"+Integer.toString(response.getAdmissionId())+"\n"+
				"Your Admission is conformed Plz Check your Personal Details & your date of Joining is 15-06-2024 "
				
						
				);
		mailSender.send(mailMessage);
		return "your admission is successfully completed...............";
	}

	private Student mappingToEntity(StudentDto studentDto) {

		Student student = new Student();
		student.setAdmissionId(studentDto.getAdmissionId());
		student.setFirstName(studentDto.getFirstName());
		student.setLastName(studentDto.getLastName());
		student.setFatherName(studentDto.getFatherName());
		student.setMotherName(studentDto.getMotherName());
		student.setIntermiadateMarks(studentDto.getIntermiadateMarks());
		student.setEmail(studentDto.getEmail());
		student.setMobileNumber(studentDto.getMobileNumber());

		return student;

	}
	private StudentDto mappingToDto(Student student) {

		StudentDto studentDto = new StudentDto();
		studentDto.setAdmissionId(student.getAdmissionId());
		studentDto.setFirstName(student.getFirstName());
		studentDto.setLastName(student.getLastName());
		studentDto.setFatherName(student.getFatherName());
		studentDto.setMotherName(student.getMotherName());
		studentDto.setIntermiadateMarks(student.getIntermiadateMarks());
		studentDto.setEmail(student.getEmail());
		studentDto.setMobileNumber(student.getMobileNumber());

		return studentDto;

	}
	

	@Override
	public Object getAll(Integer page, Integer size) throws StudentNullException {
		PageRequest pageble=PageRequest.of(page,size);
		Page<Student> student=Studentrepo.findAll(pageble);
		if(student.isEmpty())
		{
			throw new StudentNullException();
		}
		List<StudentDto> studentDto=new ArrayList<>();
		for(Student s:student)
		{
			StudentDto responseDto=mappingToDto(s);
			studentDto.add(responseDto);
		}
		return studentDto;
	}

//	@Override
//	public List<StudentDto> getAll() {
//		
//		
//		List<Student> student=Studentrepo.findAll();
//		List<StudentDto> studentDto=new ArrayList<>();
//		for(Student s:student)
//		{
//			StudentDto responseDto=mappingToDto(s);
//			studentDto.add(responseDto);
//		}
//		
//		return studentDto;
//	}

	


	


	
	
}
