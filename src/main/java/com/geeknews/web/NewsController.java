package com.geeknews.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NewsController {
	
	@GetMapping("/newsinput")
	public String Index(){
		return "release";
	}
	@ResponseBody
	@PostMapping(value = "/newsinput")
	public  Map<String,Object> NewsInput(){
		return null;
	}
}
