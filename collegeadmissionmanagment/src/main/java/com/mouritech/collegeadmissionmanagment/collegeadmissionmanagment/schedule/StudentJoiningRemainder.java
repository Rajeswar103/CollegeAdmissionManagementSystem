package com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.schedule;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.dao.StudentRepository;
import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.model.Student;

@Component
public class StudentJoiningRemainder {
	
	
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	@Autowired
	private StudentRepository studentRepo;
	
	
	@Scheduled(fixedRate = 20000)
	public void scheduleJioningDate()
	{
		
		final Logger log = LoggerFactory.getLogger(StudentJoiningRemainder.class);
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		List<Student> list = studentRepo.findAll();
		for(Student s:list)
		{
			mailMessage.setTo(s.getEmail());
			mailMessage.setFrom("rajeswarb.in@mouritech.com");
			mailMessage.setSubject("Remainder College Joining");
			mailMessage.setText("Your Date Of Joinning is Tomorrow that is 15-06-2024");
			mailSender.send(mailMessage);
			
			log.info("sendeded");
			
		}
		
		
		
	}
	
	
	

}
