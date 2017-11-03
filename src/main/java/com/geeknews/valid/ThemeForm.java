package com.geeknews.valid;

import org.hibernate.validator.constraints.NotBlank;

public class ThemeForm {
	
	@NotBlank(message="theme.themename.empty")
	private String themename;
	
	@NotBlank(message="theme.tdescription.empty")
	private String tdescription;

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
