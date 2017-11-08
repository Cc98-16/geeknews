package com.geeknews.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.geeknews.domain.Geeknews;
import com.geeknews.domain.Theme;
@Repository
@Transactional
public class NewsDao extends BaseDao<Geeknews>{
	
	public void save(Geeknews news) {
		log.debug("saving Event instance");
		try {
			getSession().save(news);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public List<Geeknews> findbytitle(String title){
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(Geeknews.class);
			dc.add(Property.forName("title").eq(title));
			Criteria criteria = dc.getExecutableCriteria(getSession());
			return criteria.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
