package com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
	
	

}
