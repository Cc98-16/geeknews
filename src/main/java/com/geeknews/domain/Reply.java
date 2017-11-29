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
@Table(name="reply")
public class Reply {
	@Id
	private String id;
	
	@ManyToOne
	@JoinColumn(name="comment_id")
	private Comment comment;
	
	private String content;
	
	@CreationTimestamp
	private Timestamp ctime;
	
	@JoinColumn(name="reply_type")
	private String replytype;
	
	@JoinColumn(name="reply_id")
	private String replyid;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@JoinColumn(name="to_uid")
	private String touser;
	
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

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCtime() {
		return ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

	public String getReplytype() {
		return replytype;
	}

	public void setReplytype(String replytype) {
		this.replytype = replytype;
	}

	public String getReplyid() {
		return replyid;
	}

	public void setReplyid(String replyid) {
		this.replyid = replyid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}
}
