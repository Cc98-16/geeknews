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

import com.geeknews.domain.Geeknews;
import com.geeknews.utils.MyPage;
@Repository
@Transactional
public class NewsDao extends BaseDao<Geeknews>{
	
	public Geeknews findById(String id){
		try {
			Geeknews geeknews = getSession().get(Geeknews.class, id);
			return geeknews;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
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
	
	public MyPage<Geeknews> findAll(String keyword,int page,int pagesize){
		try{
			DetachedCriteria dc = DetachedCriteria.forClass(Geeknews.class);
			if(StringUtils.isNotBlank(keyword)){
				Disjunction diskey = Restrictions.disjunction();
				diskey.add(Property.forName("title").like(keyword,MatchMode.ANYWHERE));
				dc.add(diskey);
			}
			return this.findPageByCriteria(dc,pagesize,page);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public MyPage<Geeknews> findtheme(String themeid,int page,int pagesize){
		try{
			DetachedCriteria dc = DetachedCriteria.forClass(Geeknews.class);
			dc.add(Property.forName("classificationid").eq(themeid));
			return this.findPageByCriteria(dc,pagesize,page);
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
