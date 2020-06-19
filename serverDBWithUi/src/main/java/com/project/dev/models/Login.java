package com.project.dev.models;


import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "login_details")
public class Login {
	
	
//	@Column(columnDefinition = "serial",)

	@Generated(GenerationTime.INSERT)
	@Column( insertable = false,name="sno",updatable = false)
	private int sno;
	
	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="email")
	private String email;
	
	@JsonIgnoreProperties(value = {"user","hibernateLazyInitializer", "handler"})
	//@JsonManagedReference
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",
				joinColumns = @JoinColumn(name="username"),
				inverseJoinColumns = @JoinColumn(name="role_id"))
	private Collection<Role> roles;

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String string() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Login() {}
	
	public Login(String username, String password, String name, String phone, String email) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Login [sno=" + sno + ", username=" + username + ", password=" + password + ", name=" + name + ", phone="
				+ phone + ", email=" + email + "]";
	}
	
}