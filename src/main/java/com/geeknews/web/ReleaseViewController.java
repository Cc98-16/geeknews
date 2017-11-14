package com.geeknews.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.geeknews.domain.Comment;
import com.geeknews.domain.Geeknews;
import com.geeknews.service.CommentService;
import com.geeknews.service.NewsService;
import com.geeknews.utils.MyPage;
@Controller
public class ReleaseViewController extends BaseController{
	
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private CommentService commentServiece;
	
	@GetMapping("/newsview/{newsid}")
	public String Index(@PathVariable String newsid,Model model){
		Geeknews geeknews = newsService.findById(newsid);
		model.addAttribute("geeknews",geeknews);
		MyPage<Comment> comment = commentServiece.findAll(geeknews, keyword, page, pagesize);
		model.addAttribute("ps",comment);
		return "newsview";
	}
}
