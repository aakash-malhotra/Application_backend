package com.project.dev.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.project.dev.dao.LoginRepo;
import com.project.dev.dao.RoleRepository;
import com.project.dev.models.Login;
import com.project.dev.models.Role;


@Component
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
		if(everStarted) {
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
		
		System.out.println("createRoleIfNotCreated(String role)" +role);
		Role r = roleRepo.findByRoleName(role);
		if(!roleService.findIfRoleExists(role)) {
		System.out.println("inside if");
			r = new Role(role);
			r = roleRepo.save(r);
		}
		//System.out.println(r);
		return r;
	}
	
	@Transactional
	public final Login createUserIfNotCreated(final String username, final String password, final String phone, final String email, final String name, final Collection<Role> roles) {
		System.out.println("createUserIfNotCreated "+username);
		boolean userExists = loginRepo.existsById(username);
		System.out.println(userExists);
		Login user = null;
		if(!userExists) {
			System.out.println("inside if");
			user = new Login(username, password, name, phone, email);
			/*user.setUsername(username);
			user.setName(name);
			user.setPassword(password);
			user.setEmail(email);
			user.setPhone(phone);
			*/
			System.out.println(user);
		}
		else {
			user = loginRepo.findByUsername(username);
		}
		user.setRoles(roles);
		user = loginRepo.save(user);
		return user;
	}
}