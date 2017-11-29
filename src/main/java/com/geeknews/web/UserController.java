package com.geeknews.web;


import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geeknews.config.WebSecurityConfig;
import com.geeknews.service.UserService;
import com.geeknews.utils.Result;
import com.geeknews.valid.UserForm;

@Controller
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String Registers(){
		return "register";
	}
	
	@ResponseBody
	@PostMapping("/register")
	public Map<String, Object> Register(@Valid UserForm userForm){
		String account = userForm.getAccount();
		userService.Register(userForm,account);
		return Result.toUrl("/login");
	}
	
	@GetMapping("/login")
	public String Index(){
		return "login";
	}
	
	@ResponseBody
	@PostMapping("/login")
	public Map<String, Object> login(HttpSession httpSession, @Valid UserForm userForm) {
		userService.Login(httpSession, userForm);
		return Result.toUrl("/");
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// 移除session
		session.removeAttribute(WebSecurityConfig.USERID);
		session.removeAttribute(WebSecurityConfig.USER);
		return "redirect:/login";
	}
	
	/*	@ResponseBody
	@PostMapping("/login")
	public Result login(HttpSession session,@RequestParam("")String account,@RequestParam("")String password)throws Exception{
		String url = "http://10.1.65.33:81/login";
		OkHttpClient okHttpClient = new OkHttpClient();
		
		RequestBody body = new FormBody.Builder()
				.add("account", account)
				.add("password", password)
				.build();
		Request request = new Request.Builder()
				.url(url)
				.post(body)
				.build();
		Response response = okHttpClient.newCall(request).execute();
		LoginResponse loginResponse = JSON.parseObject(response.body().string(), LoginResponse.class);
		
		if(loginResponse.getCode() == 200){
			session.setAttribute("userId", loginResponse.getData().getId());
			session.setAttribute("user", loginResponse.getData());
		}else if(loginResponse.getCode() == 412) {
			return new Result("/",412,"账号密码错误");
		}
		else {
			throw new ServiceException("password", "账号或密码错误");
		}
		return new Result("/", 200, "登陆成功");
	}*/
}
