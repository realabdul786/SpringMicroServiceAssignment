package com.collection;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

	@Id
	private int pid;
	private String pname;
	private String pdescription;
	private float price;
	private LocalDateTime createdAt = LocalDateTime.now();
	
	public Product() {
		super();
	}
	public Product(int pid, String pname, String pdescription, float price, LocalDateTime createdAt) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pdescription = pdescription;
		this.price = price;
		this.createdAt = createdAt;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdescription() {
		return pdescription;
	}
	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
