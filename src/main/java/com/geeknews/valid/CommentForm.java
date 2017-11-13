package com.geeknews.valid;

import org.hibernate.validator.constraints.NotBlank;

public class CommentForm {
	
	@NotBlank(message="comment.comment.empty")
	private String comment;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
