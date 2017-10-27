package com.geeknews.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.geeknews.domain.Geeknews;
@Repository
@Transactional
public class NewsDao extends BaseDao<Geeknews>{
	
	public void save(Geeknews geekNews) {
		log.debug("saving Event instance");
		try {
			getSession().save(geekNews);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
}
