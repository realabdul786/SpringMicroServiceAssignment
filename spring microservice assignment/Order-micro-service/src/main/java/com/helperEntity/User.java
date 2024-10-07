package com.helperEntity;

import java.time.LocalDateTime;

public class User {
private int uid;
	
	private String username;
	private String uemail;
	private LocalDateTime createdAt = LocalDateTime.now();
	
	public User() {
		super();
	}
	public User(int uid, String username, String uemail, LocalDateTime createdAt) {
		super();
		this.uid = uid;
		this.username = username;
		this.uemail = uemail;
		this.createdAt = createdAt;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	

}
