package com.geeknews.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.geeknews.domain.Geeknews;
import com.geeknews.service.NewsService;
@Controller
public class ReleaseViewController extends BaseController{
	
	@Autowired
	private NewsService newsService;
	
	@GetMapping("/newsview/{newsid}")
	public String Index(@PathVariable String newsid,Model model){
		Geeknews geeknews = newsService.findById(newsid);
		model.addAttribute("geeknews",geeknews);
		return "newsview";
	}
}
