package com.geeknews.service;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.geeknews.dao.CommentDao;
import com.geeknews.dao.NewsDao;
import com.geeknews.dao.UserDao;
import com.geeknews.domain.Comment;
import com.geeknews.domain.Geeknews;
import com.geeknews.domain.User;
import com.geeknews.utils.MyPage;
import com.geeknews.utils.ServiceException;
import com.geeknews.valid.CommentForm;

@Service
public class CommentService {
	
	@Resource
	private CommentDao commentDao;
	
	@Resource
	private NewsDao newsDao;
	
	@Resource
	private UserDao userDao;
	
	public void CommentSave(CommentForm commentForm,String newsid,String seuserid){
		try {
			Geeknews geeknews = newsDao.findById(newsid);
			User user = userDao.findById(seuserid);
			
			Comment comment = new Comment();
			comment.init();
			BeanUtils.copyProperties(commentForm, comment,Comment.class);
			comment.setUser(user);
			comment.setGeeknews(geeknews);
			commentDao.save(comment);
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public MyPage<Comment> findAll(Geeknews geeknews,String keyword,int page,int pagesize){
		try{
			return commentDao.findAll(geeknews,keyword, page, pagesize);		
		}catch(ServiceException e){
			throw e;
		}
	}
	
	public Comment findById(String commentid){
		try {
			return commentDao.findById(commentid);
		}catch(ServiceException e){
			throw e;
		}
	}
}
