package com.geeknews.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import com.geeknews.utils.ID;
import com.geeknews.utils.Time;

@Entity
public class User {
	
	@Id
	private String id;
	private String account;
	private String password;
	
	@CreationTimestamp
	private Timestamp ctime;
	
	public User() {
	}
	
	public void init() {
		this.id = ID.uuid();
		this.ctime = Time.timestamp();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
