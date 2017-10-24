package com.geeknews.web;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class LoginController extends BaseController{
	
	@GetMapping("/login")
	public String Index(){
		return "login";
	}
	
	@ResponseBody
	@PostMapping("/login")
	public String login(HttpSession session, String id, String account) {
		if(StringUtils.isNoneBlank(id, account)) {
			session.setAttribute("sessuserid", id);
			session.setAttribute("sessuseraccount", account);
		}
		return "/";
	}
	
	/*@ResponseBody
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
