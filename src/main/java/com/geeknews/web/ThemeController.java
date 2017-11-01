package com.geeknews.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geeknews.service.ThemeService;
import com.geeknews.valid.ThemeForm;

@Controller
public class ThemeController extends BaseController{
	
	@Resource
	private ThemeService themeService;
	
	@GetMapping("/themesave")
	public String ThemeAdd(){
		return "themesave";
	}
	
	@ResponseBody
	@PostMapping(value = "/themesave")
	public Map<String, Object> ThemeSave(@Valid ThemeForm themeForm){
		themeService.ThemeSave(themeForm);
		return null;
	}
}
