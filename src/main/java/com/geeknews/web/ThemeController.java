package com.geeknews.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geeknews.domain.Theme;
import com.geeknews.service.NewsService;
import com.geeknews.service.ThemeService;
import com.geeknews.utils.Result;
import com.geeknews.valid.ThemeForm;

@Controller
public class ThemeController extends BaseController{
	
	@Autowired
	private ThemeService themeService;
	@Autowired
	private NewsService newsService;
	
	@GetMapping("/themesave")
	public String ThemeAdd(){
		return "themesave";
	}
	
	@ResponseBody
	@PostMapping(value = "/themesave")
	public Map<String, Object> ThemeSave(@Valid ThemeForm themeForm){
		String tname = themeForm.getThemename();
		themeService.ThemeSave(themeForm,tname);
		return Result.toUrl("/");
	}
	
	@GetMapping("/tarticle/{themeid}")
	public String ThemeIndex(@PathVariable String themeid,Model model){
		model.addAttribute("theme",themeService.findAll(keyword));
		Theme theme = themeService.findById(themeid);
		model.addAttribute("ps",newsService.findtheme(theme, page, pagesize));
		model.addAttribute("themeid",themeService.findById(themeid));
		return "tarticle";
	}
}
