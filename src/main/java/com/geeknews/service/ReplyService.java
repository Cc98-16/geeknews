package com.geeknews.service;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.geeknews.dao.CommentDao;
import com.geeknews.dao.ReplyDao;
import com.geeknews.dao.UserDao;
import com.geeknews.domain.Comment;
import com.geeknews.domain.Reply;
import com.geeknews.domain.User;
import com.geeknews.utils.MyPage;
import com.geeknews.utils.ServiceException;
import com.geeknews.valid.ReplyForm;

@Service
public class ReplyService {
	
	@Resource
	private CommentDao commentDao;
	
	@Resource
	private UserDao userDao;
	
	@Resource
	private ReplyDao replyDao;
	
	public void ReplySave(ReplyForm replyForm,String commentid,String touserid,String replyid,String replytype,String seuserid){
		try {
			Comment comment = commentDao.findById(commentid);
			User user = userDao.findById(seuserid);
			
			Reply reply = new Reply();
			reply.init();
			BeanUtils.copyProperties(replyForm, reply,Reply.class);
			reply.setUser(user);
			reply.setComment(comment);
			
			reply.setTouser(touserid);
			reply.setReplyid(replyid);
			reply.setReplytype(replytype);
			
			replyDao.save(reply);
			
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public MyPage<Reply> findByComment(Comment comment,int page,int pagesize){
		try {
			return replyDao.findByComment(comment,page,pagesize);
		} catch (ServiceException e) {
			throw e;
		}
	}
}
 