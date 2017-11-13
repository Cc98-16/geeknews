package com.geeknews.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geeknews.service.CommentService;
import com.geeknews.utils.Result;
import com.geeknews.valid.CommentForm;

@Controller
public class CommentController extends BaseController{
	
	@Autowired
	private CommentService commentServiece;
	
	@ResponseBody
	@PostMapping(value = "/commentinput")
	public Map<String,Object> CommentSave(@Valid CommentForm commentForm,String newsid){
		commentServiece.CommentSave(commentForm, newsid, seuserid);
		return Result.toUrl("/newsview/"+newsid);
	}
}
