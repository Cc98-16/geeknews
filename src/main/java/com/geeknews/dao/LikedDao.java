package com.geeknews.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.geeknews.domain.Geeknews;
import com.geeknews.domain.Liked;
import com.geeknews.domain.User;
@Repository
@Transactional
public class LikedDao extends BaseDao<Liked>{
	
	public void save(Liked like) {
		log.debug("saving Event instance");
		try {
			getSession().save(like);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public List<Liked> like(User user,Geeknews geeknews){
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(Liked.class);
			dc.add(Property.forName("user").eq(user));
			dc.add(Property.forName("news").eq(geeknews));
			Criteria criteria = dc.getExecutableCriteria(getSession());
			return criteria.list();
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
	public void delete(Liked like){
		try {
			getSession().delete(like);
		} catch (RuntimeException e) {
			throw e;
		}
	}
}
