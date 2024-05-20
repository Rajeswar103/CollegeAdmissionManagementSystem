package com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{
	
	
	Admin findByName(String username);

}
