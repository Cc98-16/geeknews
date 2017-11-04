package com.geeknews.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.geeknews.domain.Theme;
@Repository
@Transactional
public class ThemeDao extends BaseDao<Theme>{
	
	public void save(Theme theme) {
		log.debug("saving Event instance");
		try {
			getSession().save(theme);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public List<Theme> findbytname(String tname){
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(Theme.class);
			dc.add(Property.forName("themename").eq(tname));
			Criteria criteria = dc.getExecutableCriteria(getSession());
			return criteria.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
