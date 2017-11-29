package com.geeknews.web;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.geeknews.domain.User;

public class BaseController {
	
	protected String seuserid;
	protected User seuser = null;
	protected String keyword;
	protected int pagesize;
	protected int page;
	
	@ModelAttribute
	public void getSeuserid(HttpSession httpSession,Model model) {
		seuser = (User) httpSession.getAttribute("seuser");
		if(seuser != null) {
			seuserid = seuser.getId();
		}
		model.addAttribute("seuser",seuser);
	}
	
	@ModelAttribute
	public void input_inti(Model model, 
			@RequestParam(value = "keyword", defaultValue = "", required = false) String keyword,
			@RequestParam(value = "pagesize", defaultValue = "7", required = false) Integer pagesize,
			@RequestParam(value = "page", defaultValue = "1", required = false) Integer page){
		this.keyword = keyword;
		this.pagesize = pagesize;
		this.page = page;
	}
	
}
