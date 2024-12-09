package com.klef.jfsd.project.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.klef.jfsd.project.entity.Admin;
import com.klef.jfsd.project.repository.AdminRepository;

@org.springframework.stereotype.Service
public class Service {
	
		@Autowired
		AdminRepository ad;
		
	
	public String register(String username, String password)
	{
		Admin aa=new Admin();
		aa.setName(username);
		aa.setPassword(password);
		ad.save(aa);
		return "Saved Successfully";
	}

}
