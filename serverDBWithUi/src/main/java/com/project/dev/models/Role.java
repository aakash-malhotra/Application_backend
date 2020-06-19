
package com.project.dev.models;
 

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Long roleId;
	
	private String roleName;
	
	@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler","roles"})
	//@JsonBackReference
	@ManyToMany(mappedBy = "roles")
	private Collection<Login> user;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public Collection<Login> getUser() {
		return user;
	}

	public void setUser(List<Login> user) {
		this.user = user;
	}

	public Role() {
		//super();
		// TODO Auto-generated constructor stub
	}

	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", user=" + user + "]";
	}
	
}