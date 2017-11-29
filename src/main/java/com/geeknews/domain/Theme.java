package com.geeknews.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.geeknews.utils.ID;
import com.geeknews.utils.Time;

@Entity
@Table(name="theme")
public class Theme {
	
	@Id
	private String id;
	
	private String themename;		//主题名称
	
	private String tdescription;	//主题描述
	
	@CreationTimestamp
	private Timestamp ctime;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Geeknews> geeknews = new ArrayList<>();

	public void init(){
		this.id = ID.uuid();
		this.ctime = Time.timestamp();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getThemename() {
		return themename;
	}

	public void setThemename(String themename) {
		this.themename = themename;
	}

	public String getTdescription() {
		return tdescription;
	}

	public void setTdescription(String tdescription) {
		this.tdescription = tdescription;
	}

	public Timestamp getCtime() {
		return ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Geeknews> getGeeknews() {
		return geeknews;
	}

	public void setGeeknews(List<Geeknews> geeknews) {
		this.geeknews = geeknews;
	}

}
