package com.geeknews.valid;

import org.hibernate.validator.constraints.NotBlank;

public class NewsForm {
	
	@NotBlank(message="news.title.empty")
	private String title;
	
	@NotBlank(message="news.content.empty")
	private String content;
	
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

}
