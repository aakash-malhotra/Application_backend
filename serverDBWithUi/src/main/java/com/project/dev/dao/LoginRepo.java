package com.project.dev.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dev.models.Login;

@Repository
public interface LoginRepo extends JpaRepository<com.project.dev.models.Login,String>{

	public Login findByUsername(String username);

}