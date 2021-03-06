package com.geeknews.web;

import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geeknews.domain.Comment;
import com.geeknews.domain.Geeknews;
import com.geeknews.domain.Reply;
import com.geeknews.domain.Theme;
import com.geeknews.service.CommentService;
import com.geeknews.service.NewsService;
import com.geeknews.service.ReplyService;
import com.geeknews.service.ThemeService;
import com.geeknews.service.UserService;
import com.geeknews.utils.MyPage;
import com.geeknews.utils.Result;
import com.geeknews.valid.NewsForm;

@Controller
public class NewsController extends BaseController{
	
	@Autowired
	private ThemeService themeService;
	
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private CommentService commentServiece;
	
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/newsinput")
	public String InputIndex(Model model){
		model.addAttribute("theme",themeService.findAll());
		return "release";
	}
	
	@PostMapping(value = "/newsinput")
	@ResponseBody
	public  Map<String,Object> NewsInput(@Valid NewsForm newsForm,String classificationid,String link){
		Theme theme = themeService.findById(classificationid);
		newsService.Newsinput(newsForm,theme,link,seuserid);
		return Result.toUrl("/");
	}
	
	@GetMapping("/newsview/{newsid}")
	public String Index(@PathVariable String newsid,Model model){
		Geeknews geeknews = newsService.findById(newsid);
		model.addAttribute("geeknews",geeknews);
		MyPage<Comment> comment = commentServiece.findAll(geeknews, keyword, page, pagesize);
		model.addAttribute("ps",comment);
		return "newsview";
	}
	
	@GetMapping("/News/{newsid}")
	public String EditMerge(Model model,@PathVariable String newsid){
		Geeknews geeknews = newsService.findById(newsid);
		model.addAttribute("news",geeknews);
		return "editrelease";
	}
	
	@ResponseBody
	@PostMapping(value ="/News/{newsid}")
	public Map<String,Object> NewsMerge(@Valid NewsForm newsForm,@PathVariable String newsid){
		newsService.NewsMerge(newsForm,newsid);
		return Result.toUrl("/newsview/"+newsid);
	}
	
	@GetMapping("/replyinput/{commentid}")
	public String ReplyInput(@PathVariable String commentid,Model model){
		Comment comment = commentServiece.findById(commentid);
		MyPage<Reply> reply = replyService.findByComment(comment, page, pagesize);
		for (Reply r : reply.getItems()) {
			if(StringUtils.isNotBlank(r.getTouser())) {
				r.setTouserbean(userService.findById(r.getTouser()));
			}
		}
		model.addAttribute("ps",reply);
		return "editreply";
	}
}
