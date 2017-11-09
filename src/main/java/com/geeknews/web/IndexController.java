package com.geeknews.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.geeknews.domain.Geeknews;
import com.geeknews.service.NewsService;
import com.geeknews.service.ThemeService;
import com.geeknews.utils.MyPage;
@Controller
public class IndexController extends BaseController{

	@Autowired
	private ThemeService themeService;
	@Autowired
	private NewsService newsService;
	
	@GetMapping("/")
	public String Index(Model model){
		MyPage<Geeknews> news = newsService.findAll(keyword,page,pagesize);
		model.addAttribute("ps",news);
		
		model.addAttribute("theme",themeService.findAll(keyword));
		return "index";
	}
}
