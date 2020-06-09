package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ticket_details")
public class Ticket extends AuditForIssuedAtModel{
	
	@Id
	@Column(name="sno")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long sno;
	
	@Column(name="category")
	private String category;
	
	@Column(name="decription")
	private String description;
	
	@Column(name="branch")
	private String branch;
	
	@Column(name="emailId")
	private String emailId;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="ticketId")
	private String ticketId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="empid",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private Login user;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public Login getUser() {
		return user;
	}

	public void setUser(Login user) {
		this.user = user;
	}

	public Ticket() {}

	public Ticket(String category, String description, String branch, String emailId, String mobile, String ticketId,
			Login user) {
		super();
		this.category = category;
		this.description = description;
		this.branch = branch;
		this.emailId = emailId;
		this.mobile = mobile;
		this.ticketId = ticketId;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Ticket [sno=" + sno + ", category=" + category + ", description=" + description + ", branch=" + branch
				+ ", emailId=" + emailId + ", mobile=" + mobile + ", ticketId=" + ticketId + ", user=" + user + "]";
	}
	
	
	

}
