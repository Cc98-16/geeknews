package com.geeknews.web;

import com.geeknews.domain.User;

public class LoginResponse {
	
	private int code;
	private int status;
	private String msg;
	private User data;
	private String error;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public User getData() {
		return data;
	}
	public void setData(User data) {
		this.data = data;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
}
