package com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.dao.AdminRepository;
import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.model.Admin;


@Service
public class CustomAdminService implements UserDetailsService {
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		Admin user = adminRepository.findByName(username);
		AdminInfo adminInfo=null;
		if(user==null)
		{
			throw new UsernameNotFoundException("user is not found..........");
		}
		adminInfo=new AdminInfo();
		adminInfo.setAdmin(user);
		return adminInfo;
	}

}
