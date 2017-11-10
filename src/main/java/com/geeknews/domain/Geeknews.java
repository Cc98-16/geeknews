package com.geeknews.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.geeknews.utils.ID;
import com.geeknews.utils.Time;

@Entity
@Table(name="geeknews")
public class Geeknews {
	
	@Id
	private String id;
	
	private String userid;		//发布的用户
	
	private String title;		//标题
	
	private String content;		//内容
	
	private String link;		//链接
	
	private String classificationid; //分类ID
	
	@CreationTimestamp
	private Timestamp ctime;	//发布时间
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comment = new ArrayList<>();
	
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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getClassificationid() {
		return classificationid;
	}

	public void setClassificationid(String classificationid) {
		this.classificationid = classificationid;
	}

	public Timestamp getCtime() {
		return ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	
}
