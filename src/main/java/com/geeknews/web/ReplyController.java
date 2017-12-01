package com.geeknews.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geeknews.service.ReplyService;
import com.geeknews.utils.Result;
import com.geeknews.valid.ReplyForm;

@Controller
public class ReplyController extends BaseController{
	
	@Autowired
	private ReplyService  replyService;
	
	@ResponseBody
	@PostMapping(value="/replyinput")
	public Map<String,Object> ReplySave(@Valid ReplyForm replyForm,String commentid,String touser,String replyid,String replytype,String newsid){
		replyService.ReplySave(replyForm, commentid, touser, replyid, replytype, seuserid);
		return Result.toUrl("/newsview/"+newsid);
	}
}
