package com.geeknews.dao;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.geeknews.domain.Comment;
import com.geeknews.domain.Geeknews;
import com.geeknews.utils.MyPage;

@Repository
@Transactional
public class CommentDao extends BaseDao<Comment>{
	
	public void save(Comment comment) {
		log.debug("saving Event instance");
		try {
			getSession().save(comment);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public MyPage<Comment> findAll(Geeknews geeknews,String keyword,int page,int pagesize){
		try{
			DetachedCriteria dc = DetachedCriteria.forClass(Comment.class);
			dc.add(Property.forName("geeknews").eq(geeknews));
			if(StringUtils.isNotBlank(keyword)){
				Disjunction diskey = Restrictions.disjunction();
				diskey.add(Property.forName("comment").like(keyword,MatchMode.ANYWHERE));
				dc.add(diskey);
			}
			return this.findPageByCriteria(dc,pagesize,page);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public Comment findById(String id){
		try {
			Comment comment = getSession().get(Comment.class, id);
			return comment;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
