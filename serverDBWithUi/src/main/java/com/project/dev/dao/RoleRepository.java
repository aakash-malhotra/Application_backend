package com.project.dev.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dev.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	public Role findByRoleName(String roleName);
}