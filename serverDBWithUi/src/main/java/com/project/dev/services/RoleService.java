package com.project.dev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dev.dao.RoleRepository;
import com.project.dev.models.Role;

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