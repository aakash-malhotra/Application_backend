package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.LoginRepo;
import com.example.demo.dao.RoleRepository;
import com.example.demo.model.Login;
import com.example.demo.model.Role;

public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent>  {

	private boolean everStarted = false;
	
	@Autowired
	private LoginRepo loginRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(!everStarted) {
			return;
		}	
		else {
		final Role admin = createRoleIfNotCreated("ROLE_ADMIN");
		final Role user = createRoleIfNotCreated("ROLE_USER");
		
		createUserIfNotCreated("admin","admin","0123456789","admin@tcs.com","admin",new ArrayList<Role>(Arrays.asList(admin)));
		everStarted = true;
		}
	}

	@Transactional
	public Role createRoleIfNotCreated(String role) {
		Role r = roleRepo.findByRoleName(role);
		if(roleService.findIfRoleExists(role)) {
			r = new Role(role);
			r = roleRepo.save(r);
		}
		return r;
	}
	
	@Transactional
	public Login createUserIfNotCreated(String username, String password, String phone, String email, String name, Collection<Role> roles) {
		Login user = loginRepo.findByUsername(username);
		if(user == null) {
			user.setUsername(username);
			user.setName(name);
			user.setPassword(password);
			user.setEmail(email);
			user.setPhone(phone);
		}
		user.setRoles(roles);
		user = loginRepo.save(user);
		return user;
	}
}