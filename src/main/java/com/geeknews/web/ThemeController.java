package com.geeknews.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geeknews.domain.Theme;
import com.geeknews.service.ThemeService;
import com.geeknews.utils.MyPage;
import com.geeknews.utils.Result;
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
		String tname = themeForm.getThemename();
		themeService.ThemeSave(themeForm,tname);
		return Result.toUrl("/");
	}
	
	@GetMapping(value = "/theme")
	public String ThemeIndex(Model model){
		MyPage<Theme> theme = themeService.findAll(keyword, page, pagesize);
		model.addAttribute("ps",theme);
		return "theme";
	}
}
