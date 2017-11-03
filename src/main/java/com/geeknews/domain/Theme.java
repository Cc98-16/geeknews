package com.geeknews.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.geeknews.utils.ID;

@Entity
@Table(name="theme")
public class Theme {
	
	@Id
	private String id;
	
	private String themename;		//主题名称
	
	private String tdescription;	//主题描述

	public void init(){
		this.id = ID.uuid();
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
	
}
