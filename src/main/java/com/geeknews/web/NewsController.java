package com.geeknews.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsController {
	@GetMapping("/newsinput")
	public String Index(){
		return "release";
	}
}
