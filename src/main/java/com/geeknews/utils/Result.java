package com.geeknews.utils;

import java.util.HashMap;
import java.util.Map;

public class Result {
	private String tourl;
	private int code;
	private String msg;
	
	public static Map<String, Object> toUrl(String url) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tourl", url);
		return map;
	}
	
	public Result() {
	}

	public Result(String tourl, int code, String msg) {
		this.tourl = tourl;
		this.code = code;
		this.msg = msg;
	}
	
	public static Map<String, Object> success() {
		return set("success");
	}
	
	public static Map<String, Object> error() {
		return set("error");
	}
	
	public static Map<String, Object> failed() {
		return set("failed");
	}
	
	public static Map<String, Object> yes() {
		return set("yes");
	}
	
	public static Map<String, Object> no() {
		return set("no");
	}
	
	public static Map<String, Object> set(String result) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		return map;
	}

	public String getTourl() {
		return tourl;
	}

	public void setTourl(String tourl) {
		this.tourl = tourl;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
