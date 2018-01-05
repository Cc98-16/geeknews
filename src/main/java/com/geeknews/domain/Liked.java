package com.geeknews.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.geeknews.utils.ID;

@Entity
@Table(name="liked")
public class Liked {
	
	@Id
	private String id;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name="news_id")
	private Geeknews news;
	
	public void init(){
		this.id = ID.uuid();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Geeknews getNews() {
		return news;
	}

	public void setNews(Geeknews news) {
		this.news = news;
	}
	
	
}
