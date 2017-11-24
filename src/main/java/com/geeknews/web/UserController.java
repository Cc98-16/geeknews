package com.geeknews.web;


import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geeknews.utils.Result;
import com.geeknews.valid.UserForm;

@Controller
public class UserController extends BaseController{

	@GetMapping("/register")
	public String Registers(){
		return "register";
	}
	
	@ResponseBody
	@PostMapping("/register")
	public Map<String, Object> Register(@Valid UserForm userForm){
		
		return Result.toUrl("");
	}
}
