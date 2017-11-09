package com.geeknews.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geeknews.dao.NewsDao;
import com.geeknews.domain.Geeknews;
import com.geeknews.utils.MyPage;
import com.geeknews.utils.ServiceException;
import com.geeknews.valid.NewsForm;

@Service
@Transactional
public class NewsService {
	
	@Resource
	private NewsDao newsDao;
	
	public void Newsinput(NewsForm newsForm,String classificationid,String link,String seuserid){
		try {
			List<Geeknews> title = newsDao.findbytitle(newsForm.getTitle());
			if(title !=null && !title.isEmpty()){
				throw new ServiceException("title","此文章已存在，请勿重复创建");
			}else{
				Geeknews news = new Geeknews();
				news.init();
				BeanUtils.copyProperties(newsForm, news,Geeknews.class);
				news.setLink(link);
				news.setUserid(seuserid);
				news.setClassificationid(classificationid);
				newsDao.save(news);
			}
			
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public MyPage<Geeknews> findAll(String keyword,int page,int pagesize){
		try{
			return newsDao.findAll(keyword, page, pagesize);		
		}catch(ServiceException e){
			throw e;
		}
	}
}
