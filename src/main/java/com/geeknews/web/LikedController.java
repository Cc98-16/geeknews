package com.geeknews.web;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geeknews.service.LikedService;
import com.geeknews.utils.Result;

@Controller
public class LikedController extends BaseController{
	
	@Autowired
	private LikedService likeService;
	
	
	@PostMapping(value = "/liked")
	@ResponseBody
	public Map<String, Object> Like(String newsid){
		likeService.Like(newsid, seuserid);
		return Result.success();
	}
}
