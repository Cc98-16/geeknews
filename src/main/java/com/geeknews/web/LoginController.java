package com.geeknews.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoginController {
	@GetMapping("/login")
	public String Index(){
		return "login";
	}
}
