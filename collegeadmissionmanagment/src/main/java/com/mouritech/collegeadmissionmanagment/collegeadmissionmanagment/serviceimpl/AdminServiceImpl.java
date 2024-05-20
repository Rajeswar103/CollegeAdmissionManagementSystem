package com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.dao.AdminRepository;
import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.dto.AdminDto;
import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.model.Admin;
import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService{
	
	
	@Autowired
	private AdminRepository adminRepo;
	@Autowired
	private PasswordEncoder encode;

	@Override
	public Object setValues(AdminDto adminDto) {
		
		Admin admin=mappingToEntity(adminDto);
		String s = admin.getPassword();
		admin.setPassword(encode.encode(s));
		Admin response=adminRepo.save(admin);
		return "Sended Scuceesfully..............";
	}
	
	private Admin mappingToEntity(AdminDto adminDto)
	{
		Admin admin=new Admin();
		admin.setId(adminDto.getId());
		admin.setName(adminDto.getName());
		admin.setPassword(adminDto.getPassword());
		admin.setRole(adminDto.getRole());
		return admin;
		
	}
	

}
