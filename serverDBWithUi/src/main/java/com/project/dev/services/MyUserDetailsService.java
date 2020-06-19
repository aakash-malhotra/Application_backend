package com.project.dev.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.dev.dao.LoginRepo;
import com.project.dev.models.Login;
import com.project.dev.models.Role;



@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private LoginRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Login login = repo.findByUsername(username);
		System.out.println(login);
		if(login==null) {
			System.out.println("User not found 404");
			throw new UsernameNotFoundException("User not found 404");
		}
		//return new UserPrincipal(login);
		return new org.springframework.security.core.userdetails.User(login.getUsername(), 
			    						login.getPassword(), getAuthorities(login.getRoles()));
	}

	public Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
	
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for(Role role : roles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		return grantedAuthorities;
	}	
}
