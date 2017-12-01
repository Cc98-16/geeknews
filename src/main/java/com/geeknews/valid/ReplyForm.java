package com.geeknews.valid;

import org.hibernate.validator.constraints.NotBlank;

public class ReplyForm {
	@NotBlank(message="reply.content.empty")
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
