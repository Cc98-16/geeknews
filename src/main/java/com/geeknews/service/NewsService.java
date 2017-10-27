package com.geeknews.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geeknews.dao.NewsDao;

@Service
@Transactional
public class NewsService {
	
	@Resource
	private NewsDao newsDao;
}
