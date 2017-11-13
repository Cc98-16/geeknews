package com.geeknews.service;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.geeknews.dao.CommentDao;
import com.geeknews.dao.NewsDao;
import com.geeknews.domain.Comment;
import com.geeknews.domain.Geeknews;
import com.geeknews.utils.ServiceException;
import com.geeknews.valid.CommentForm;

@Service
public class CommentService {
	
	@Resource
	private CommentDao commentDao;
	@Resource
	private NewsDao newsDao;
	
	public void CommentSave(CommentForm commentForm,String newsid,String seuserid){
		try {
			Geeknews geeknews = newsDao.findById(newsid);
			
			Comment comment = new Comment();
			comment.init();
			BeanUtils.copyProperties(commentForm, comment,Comment.class);
			comment.setUserid(seuserid);
			comment.setGeeknews(geeknews);
			commentDao.save(comment);
			
		} catch (ServiceException e) {
			throw e;
		}
	}
}
