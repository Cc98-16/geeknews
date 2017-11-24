package com.geeknews.valid;

import org.hibernate.validator.constraints.NotBlank;

public class UserForm {
	
	@NotBlank(message="theme.account.empty")
	private String account;
	@NotBlank(message="theme.password.empty")
	private String password;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
