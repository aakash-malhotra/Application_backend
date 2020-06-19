package com.project.dev.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

@Entity
@Table(name="server_details")
public class serverDb implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sno")
	private int sno;
	
	@Column(name="server")
	private String server;
	
	@Column(name="server_instance")
	private String server_instance;
	
	@Column(name="port")
	private int port;
	
	@Column(name="environment")
	private String environment;
	
	@Column(name="status")
	private String status;
	
	@Column(name="downtime")
	private String date;
	
	@Column(name="remarks")
	private String remarks;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getServer_instance() {
		return server_instance;
	}
	public void setServer_instance(String server_instance) {
		this.server_instance = server_instance;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "serverDb [sno=" + sno + ", server=" + server + ", server_instance=" + server_instance + ", port=" + port
				+ ", environment=" + environment + ", status=" + status + ", remarks=" + remarks + "]";
	}

}
