package com.geeknews.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.geeknews.domain.Theme;
import com.geeknews.utils.MyPage;
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
	
	public List<Theme> findAll(String keyword){
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(Theme.class);
			if(StringUtils.isNotBlank(keyword)){
				Disjunction diskey = Restrictions.disjunction();
				diskey.add(Property.forName("themename").like(keyword,MatchMode.ANYWHERE));
				dc.add(diskey);
			}
			Criteria criteria = dc.getExecutableCriteria(getSession());
			return criteria.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
/*	public MyPage<Theme> findAll(String keyword,int page,int pagesize){
		try{
			DetachedCriteria dc = DetachedCriteria.forClass(Theme.class);
			if(StringUtils.isNotBlank(keyword)){
				Disjunction diskey = Restrictions.disjunction();
				diskey.add(Property.forName("themename").like(keyword,MatchMode.ANYWHERE));
				dc.add(diskey);
			}
			return this.findPageByCriteria(dc,pagesize,page);
		} catch (RuntimeException re) {
			throw re;
		}
	}*/
}
