package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RoleRepository;
import com.example.demo.model.Role;

@Service
public class RoleService{
	
	@Autowired
	private RoleRepository roleRepo;
	
	public boolean findIfRoleExists(String role) {
		Role r = roleRepo.findByRoleName(role);
		if(r==null)
			return false;
		else
			return true;
	}
}