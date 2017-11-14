package com.geeknews.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.geeknews.utils.ID;
import com.geeknews.utils.Time;

@Entity
@Table(name="comment")
public class Comment {
	
	@Id
	private String id;
	
	private String comment;			//发布的评论
	
	private String userid;			//发布的用户
	
    @ManyToOne
    @JoinColumn(name="geeknews_id")
	private Geeknews geeknews;
    
	@CreationTimestamp
	private Timestamp ctime;		//发布时间
	
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Geeknews getGeeknews() {
		return geeknews;
	}

	public void setGeeknews(Geeknews geeknews) {
		this.geeknews = geeknews;
	}

	public Timestamp getCtime() {
		return ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}
	
}
