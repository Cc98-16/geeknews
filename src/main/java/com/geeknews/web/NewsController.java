package com.geeknews.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geeknews.service.NewsService;
import com.geeknews.service.ThemeService;
import com.geeknews.utils.Result;
import com.geeknews.valid.NewsForm;

@Controller
public class NewsController extends BaseController{
	
	@Autowired
	private ThemeService themeService;
	
	@Autowired
	private NewsService newsService;
	
	@GetMapping("/newsinput")
	public String InputIndex(Model model){
		model.addAttribute("theme",themeService.findAll(keyword));
		return "release";
	}
	@ResponseBody
	@PostMapping(value = "/newsinput")
	public  Map<String,Object> NewsInput(@Valid NewsForm newsForm,String classificationid,String link){
		newsService.Newsinput(newsForm,classificationid,link,seuserid);
		return Result.toUrl("/");
	}
}
