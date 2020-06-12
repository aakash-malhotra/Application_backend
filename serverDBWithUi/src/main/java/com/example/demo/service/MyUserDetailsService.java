package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.loginRepo;
import com.example.demo.model.Login;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private loginRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Login login = repo.findByUsername(username);
		if(login==null) {
			throw new UsernameNotFoundException("User not found 404");
		}
	
		return new UserPrincipal(login);
	/*	
		Set grantedAuthorities = new HashSet<>();
	    for (Role role : login.getRoles()){
	        grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
	    }

	    return new org.springframework.security.core.userdetails.User(login.getUsername(), 
	    login.getPassword(), grantedAuthorities);
	 */
	}
	
	
	
}