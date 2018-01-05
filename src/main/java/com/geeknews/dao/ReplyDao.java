package com.geeknews.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.geeknews.domain.Comment;
import com.geeknews.domain.Reply;
import com.geeknews.utils.MyPage;

@Repository
@Transactional
public class ReplyDao extends BaseDao<Reply>{
	
	public void save(Reply reply) {
		log.debug("saving Event instance");
		try {
			getSession().save(reply);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public MyPage<Reply> findByComment(Comment comment,int page,int pagesize){
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(Reply.class);
			dc.add(Property.forName("comment").eq(comment));
			dc.addOrder(Order.asc("ctime"));
			return this.findPageByCriteria(dc,pagesize,page);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
}
