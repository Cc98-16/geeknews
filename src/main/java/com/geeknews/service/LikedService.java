package com.geeknews.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.geeknews.dao.LikedDao;
import com.geeknews.dao.NewsDao;
import com.geeknews.dao.UserDao;
import com.geeknews.domain.Geeknews;
import com.geeknews.domain.Liked;
import com.geeknews.domain.User;
import com.geeknews.utils.ServiceException;

@Service
public class LikedService {
	
	@Resource
	private NewsDao newsDao;
	
	@Resource
	private UserDao userDao;
	
	@Resource
	private LikedDao likeDao;
	
	public void Like(String newsid,String seuserid){
		try {
			Geeknews news = newsDao.findById(newsid);
			User user = userDao.findById(seuserid);
			List<Liked> list=likeDao.like(user, news);
			if(list != null && list.size()>0){
				Liked like = list.get(0);
				likeDao.delete(like);
				
				news.setLikenum(news.getLikenum()-1);
				newsDao.merge(news);
			}else{
				Liked like = new Liked();
				like.init();
				like.setNews(news);
				like.setUser(user);
				likeDao.save(like);
				
				news.setLikenum(news.getLikenum()+1);
				newsDao.merge(news);
			}
		} catch (ServiceException e) {
			throw e;
		}
	}
}
