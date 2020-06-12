/*
package com.example.demo.model;
 

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;
	
	private String roleName;
	
	@ManyToMany(mappedBy = "roles")
	private List<Login> user;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Login> getUser() {
		return user;
	}

	public void setUser(List<Login> user) {
		this.user = user;
	}

	public Role() {
		//super();
		// TODO Auto-generated constructor stub
	}

	public Role(String roleName, List<Login> user) {
		super();
		this.roleName = roleName;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", user=" + user + "]";
	}
	
	
}
*/