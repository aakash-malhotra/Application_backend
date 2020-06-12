
package com.example.demo.model;
 

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Long roleId;
	
	private String roleName;
	
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