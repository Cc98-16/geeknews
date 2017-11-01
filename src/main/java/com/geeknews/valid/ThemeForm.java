package com.geeknews.valid;

import org.hibernate.validator.constraints.NotBlank;

public class ThemeForm {
	
	@NotBlank(message="theme.themename.empty")
	private String themename;

	public String getThemename() {
		return themename;
	}

	public void setThemename(String themename) {
		this.themename = themename;
	}
	
}
