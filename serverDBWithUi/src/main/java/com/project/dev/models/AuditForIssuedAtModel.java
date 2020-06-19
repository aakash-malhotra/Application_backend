package com.project.dev.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true,value = "issuedAt")
public abstract class AuditForIssuedAtModel implements Serializable{
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "issuedAt", nullable = false, updatable = false)
	@CreatedDate
	private Date issuedAt;

	public Date getIssuedAt() {
		return issuedAt;
	}

	public void setIssuedAt(Date issuedAt) {
		this.issuedAt = issuedAt;
	}

	@Override
	public String toString() {
		return "AuditForIssuedAtModel [issuedAt=" + issuedAt + "]";
	}
	
	
}
